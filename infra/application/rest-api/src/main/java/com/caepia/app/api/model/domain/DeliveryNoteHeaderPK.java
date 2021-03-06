package com.caepia.app.api.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class DeliveryNoteHeaderPK implements Serializable {

    @Id
    @Column(name = "PK_DeliveryNote")
    private Integer deliveryNoteId;


}
