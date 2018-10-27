package com.caepia.app.api.service.domain;

import com.caepia.app.api.model.domain.ModelEntity;
import com.caepia.app.api.repository.domain.SalesProductRepository;
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
public class SalesProductService {
    private final SalesProductRepository salesProductRepository;


    private final String SALES_PRODUCT_PRODUCTION_ORDER_CENTER = "findAllByProductionOrderId";



    /**
     * Retrieves, page by page, all authorized {@link ModelEntity}s for a particular {@code Order}.
     *
     * @param productionOrderId identifier for the production order
     * @param page     requested page number
     * @param size     requested page size
     * @return a page of authorized {@link ModelEntity}s
     */
    public Iterable<ModelEntity> getSalesProductsByProductionOrders(Integer productionOrderId,
                                                                  Optional<Integer> page,
                                                                  Optional<Integer> size)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {


        StringBuilder methodName = new StringBuilder(SALES_PRODUCT_PRODUCTION_ORDER_CENTER);
        List parameters = new ArrayList(Arrays.asList(productionOrderId));

        methodName.append(this.isPageRequest(page, size) && parameters
                        .add(PageRequest.of(this.transformDefaultPage(page.get()), size.get())) ? "" : "");

        this.log.debug("Calling repository method: %s", methodName.toString());

        return this.dynamicRepositoryCall(this.salesProductRepository,methodName.toString(),parameters.toArray(new Object[parameters.size()]));



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
