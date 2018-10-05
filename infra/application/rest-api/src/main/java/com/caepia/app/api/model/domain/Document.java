package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(DocumentPK.class)
@Table(name = "vAPIStatusDocuments")
public class Document {
    @Id
    @Column(name = "PK_Status")
    private Integer statusId;

    @Id
    @Column(name = "PK_Document")
    private Integer documentId;

    @Column(name = "StatusName")
    private String statusName;

    @Column(name = "StatusOrder")
    private Integer statusOrder;


}
