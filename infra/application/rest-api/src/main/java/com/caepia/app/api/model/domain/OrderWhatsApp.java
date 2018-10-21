package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
@IdClass(OrderWhatsAppPK.class)
@Table(name = "vApiOrdersWhatsAppParams")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderWhatsApp extends ModelEntity {
    @Id
    @Column(name = "PK_Order")
    private Integer orderId;

    @Column(name = "TextWhatsAppOrder")
    private String textWhatsAppOrder;

    @Column(name = "ContactCellPhone")
    private String contactCellPhone;

}
