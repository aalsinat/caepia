package com.caepia.app.api.controller.domain;

import com.caepia.app.api.model.domain.Document;
import com.caepia.app.api.security.JwtUser;
import com.caepia.app.api.service.domain.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentControllerImpl extends AbstractController implements DocumentController {

    private final DocumentService documentService;


    /**
     * Get all authorized {@link Document}s
     *
     * @return
     */
    @Override
    @GetMapping(value = "/documents/status")
    public ResponseEntity<Iterable<Document>> getAllDocuments() {

        Iterable<Document> orderRows = documentService.getAllDocuments();
        return ResponseEntity.ok(orderRows);
    }

    // -----------------------------
    //  Class support methods
    // -----------------------------

    /**
     * Checks if provided {@code Center} identifier is eligible considering current logged user security context.
     *
     * @param centerId identifier for the center
     * @return true if center is eligible, false otherwise
     */
    private boolean isEligible(Integer centerId) {
        return ((JwtUser) getContext().getAuthentication().getPrincipal()).getCenters().stream().map(s -> s.getCostCenter()).anyMatch(centerId::equals);
    }

    private Object includeProperties(Object source, List<String> properties) {
        // Create ObjectMapper instance
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Converting POJO to Map
//        Map<String, Object> map = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
//        });
//
//        //
//        for(Map.Entry<String, Object> entry : map.entrySet()){
//            if(entry.getKey()){
//                System.out.println(entry.getKey() + "-->" + entry.getValue());
//            }
//        }
//        // Convert Map to POJO
//        Object anotherFoo = mapper.convertValue(map, Object.class);
//        return anotherFoo;
        return null;
    }


}






























