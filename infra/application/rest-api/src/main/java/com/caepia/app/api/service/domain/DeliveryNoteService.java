package com.caepia.app.api.service.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.DeliveryNoteHeader;
import com.caepia.app.api.model.domain.DeliveryNoteRow;
import com.caepia.app.api.model.domain.OrderHeader;
import com.caepia.app.api.repository.domain.DeliveryNoteHeaderRepository;
import com.caepia.app.api.repository.domain.DeliveryNoteRowRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliveryNoteService {
    private final DeliveryNoteHeaderRepository deliveryNoteHeaderRepository;
    private final DeliveryNoteRowRepository deliveryNoteRowRepository;


    private final String DELIVERY_NOTE_HEADER = "findAllByfindAllByCenterId";
    private final String DELIVERY_NOTE_ROW = "findAllByDeliveryNoteId";

    /**
     * Retrieves, page by page, all authorized {@link DeliveryNoteHeader}s for a particular {@code Center}.
     *
     * @param centerId identifier for the center
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link DeliveryNoteHeader}s
     */
    public Iterable<ModelEntity> getDeliveryNotesByCenterId(Integer centerId,
                                                            Optional<String> filterDate,
                                                            Optional<Integer> owner,
                                                            Optional<Integer> status,
                                                            Optional<Integer> orderId,
                                                            Optional<Integer> page,
                                                            Optional<Integer> size) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StringBuilder methodName = new StringBuilder(DELIVERY_NOTE_HEADER);
        List parameters = new ArrayList(Arrays.asList(centerId));

        methodName.append(status.isPresent() && parameters.add(status.get()) ? "AndStatus" : "")
                .append(owner.isPresent() && parameters.add(owner.get()) ? "AndOwner" : "")
                .append(orderId.isPresent() && parameters.add(orderId.get()) ? "AndOrderId" : "")
                .append(filterDate.isPresent() && parameters.add(filterDate.get()) ? "AndDeliveryNoteDateGreaterThanEqual" : "")
                .append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");




        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.deliveryNoteHeaderRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));
    }




    /**
     * Retrieves, page by page, all authorized {@link DeliveryNoteRow}s for a particular {@code Order}.
     *
     * @param deliveryNotesId identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link DeliveryNoteRow}s
     */
    public Iterable<ModelEntity> getDeliveryNotesRowsByDeliveryNotesId(Integer deliveryNotesId,
                                                                        Optional<String> type,
                                                                        Optional<Integer> categoryL3Id,
                                                                        Optional<Integer> swBookmark,
                                                                        Optional<Integer> page,
                                                                        Optional<Integer> size)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StringBuilder methodName = new StringBuilder(DELIVERY_NOTE_ROW);
        List parameters = new ArrayList(Arrays.asList(deliveryNotesId));

        methodName.append(type.isPresent() && parameters.add(type.get()) ? "AndGetType" : "")
                .append(categoryL3Id.isPresent() && parameters.add(categoryL3Id.get()) ? "AndCategoryL3Id" : "")
                .append(swBookmark.isPresent() && parameters.add(swBookmark.get()) ? "AndSwBookmark" : "")
                .append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");


        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.deliveryNoteRowRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));


    }


    /**
     * Create a new {@link OrderHeader} for a existing center .
     *
     * @param costCenter    identifier for the center
     * @param deliveryNoteDate   deliveryNote date
     * @param vendor     identifier for the vendor
     * @param vendorNumDoc    vendor num doc
     * @param vendorDate    vendor date
     * @param comments  comments
     * @param userId   identifier for the user
     *
     */


    public StoredProcedureResult createDeliveryNoteHeader(Integer costCenter, String deliveryNoteDate , Integer vendor, String vendorNumDoc, String vendorDate, String comments, Integer userId) {
        StoredProcedureResult result = deliveryNoteHeaderRepository.createDeliveryNoteHeader(costCenter, deliveryNoteDate, vendor, vendorNumDoc, vendorDate, comments, userId);
        return result;

    }




    /* ------------------------ */
    /*    Support methods       return this.dynamicRepositoryCall(this.productRepository, methodName.toString(), parameters.toArray(new Object[parameters.size()]));*/
    /* ------------------------ */

    /**
     * Dynamic method for requesting repository methods.
     *
     * @param repository Repository used to make the dynamic call
     * @param methodName Name of the method to be called
     * @param parameters Parameters to be passed in to the method
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Iterable<ModelEntity> dynamicRepositoryCall(JpaRepository repository, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Class<?>[] types = Arrays.asList(parameters).stream()
                .map(this::getClassNameFromParameter)
                .collect(Collectors.toList())
                .toArray(new Class<?>[parameters.length]);
        Method method = repository.getClass().getMethod(methodName, types);

        return (Iterable<ModelEntity>) method.invoke(repository, parameters);
    }



    /**
     * Given an object it returns its {@link Class}. If implements Pageable interface, its will return this inteface as {@link Class}.
     *
     * @param param object to be requested
     * @return {@link Class} or {@code interface} of the provided object
     */
    private Class<?> getClassNameFromParameter(Object param) {
        return Pageable.class.isAssignableFrom(param.getClass()) ? Pageable.class : param.getClass();
    }

    private boolean isPageRequest(Optional<Integer> page, Optional<Integer> size) {
        return page.isPresent() && size.isPresent();
    }

    private Integer transformDefaultPage(Integer page) {
        return (page-- <= 0 ? page = 0 : page);

    }

}
