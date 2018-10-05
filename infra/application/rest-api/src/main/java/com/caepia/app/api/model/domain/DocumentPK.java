package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class DocumentPK implements Serializable {
    @Id
    @Column(name = "PK_Status")
    private Integer statusId;

    @Id
    @Column(name = "PK_Document")
    private Integer documentId;


}
