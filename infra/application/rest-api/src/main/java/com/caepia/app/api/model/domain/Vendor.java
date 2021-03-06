package com.caepia.app.api.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@IdClass(VendorPK.class)
@Table(name = "vApiCenterVendors")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vendor extends ModelEntity {
    @Id
    @Column(name = "PK_CostCenter")
    private Integer centerId;
    @Id
    @Column(name = "PK_Vendor")
    private Integer id;

    @Column(name = "CenterName")
    private String centerName;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "NIF")
    private String taxId;

    @Column(name = "Adress1")
    private String addressLine1;

    @Column(name = "Adress2")
    private String addressLine2;

    @Column(name = "ZipCode")
    private String zipCode;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "CatalogType")
    private Integer catalogType;

    @Column(name = "VendorPriority")
    private Integer priority;

    @Column(name = "CalendarFixed")
    private Integer isCalendarFixed;

    @Column(name = "CalendarType")
    private Integer calendarType;

    @Column(name = "CalendarParams")
    private Integer calendarParams;

    @Column(name = "CalendarInfo")
    private String calendarInfo;

    @Column(name = "SendChannels")
    private Integer sendChannels;

    @Column(name = "SendChannelsName")
    private String sendChannelsName;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactPhone")
    private String contactPhone;

    @Column(name = "ContactCellPhone")
    private String contactCellPhone;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "ProductsCount")
    private Integer productsCount;

    @Column(name = "ProductsBookmarkCount")
    private Integer bookmarkedProductsCount;

    @Column(name = "swCatalogFixed")
    private Integer swCatalogFixed;

}
