package com.caepia.app.api.service.domain;

import com.caepia.app.api.dto.StoredProcedureResult;
import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.model.domain.ProductionOrder;

import com.caepia.app.api.repository.domain.ProductionOrderRepository;
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
public class ProductionOrderService {
    private final ProductionOrderRepository productionOrderRepository;


    private final String PRODUCTION_ORDER_CENTER = "findAllByCenterId";



    /**
     * Retrieves, page by page, all authorized {@link ModelEntity}s for a particular {@code Order}.
     *
     * @param centerId identifier for the order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link ModelEntity}s
     */
    public Iterable<ModelEntity> getProductionOrdersByCenterId(Integer centerId,
                                                                  Optional<Integer> status,
                                                                  Optional<Integer> owner,
                                                                  Optional<String> orderDate,
                                                                  Optional<Integer> page,
                                                                  Optional<Integer> size)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {


        StringBuilder methodName = new StringBuilder(PRODUCTION_ORDER_CENTER);
        List parameters = new ArrayList(Arrays.asList(centerId));


        methodName.append(status.isPresent() && parameters.add(status.get()) ? "AndStatus" : "")
                .append(owner.isPresent() && parameters.add(owner.get()) ? "AndOwner" : "")
                .append(orderDate.isPresent() && parameters.add(orderDate.get()) ? "AndProdOrderDateGreaterThanEqual" : "")
                .append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");

        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.productionOrderRepository,methodName.toString(),parameters.toArray(new Object[parameters.size()]));



    }



    /**
     * Create a new {@link ProductionOrder} for a existing center .
     *
     * @param costCenter    identifier for the center
     * @param userId   identifier for the user
     *
     */


    public StoredProcedureResult createProductionOrder(Integer costCenter, Integer userId) {
        StoredProcedureResult result = productionOrderRepository.createProductionOrder(costCenter,  userId);

        return result;
    }


    public StoredProcedureResult changeStatusProductionOrder(Integer productionOrderId, Integer status, Integer userId) {
        StoredProcedureResult result = productionOrderRepository.changeStatusProductionOrder(productionOrderId, status, userId);

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
