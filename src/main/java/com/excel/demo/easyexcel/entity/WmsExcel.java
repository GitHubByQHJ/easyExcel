package com.excel.demo.easyexcel.entity;

import lombok.Data;

/**
 * @author quehaijun
 * @date 2020/11/17 下午8:06
 **/
@Data
public class WmsExcel{

  private Integer no;

  private String deliveryBillNo;

  private String orderSource;

  private String externalOrderNo;

  private Boolean status;

  private Boolean warehouse;

  private Integer storeName;

  private String creator;

  private String createdTime;

  private String freight;

  private String orderAmount;

  private String addressDetail;

  private String district;

  private String city;

  private String province;

  private String postalCode;

  private String consignee;

  private String phoneNumber;

  private String noteFromBuyer;

  private String noteFromSeller;

  private String paymentMethod;

  private String packedTime;

  private String deliveryTime;

  private String completeTime;

  private String carrier;

  private String trackingNo;

  private String salesman;

  private String goodsName;

  private String goodsSpecification;

  private String barcode;

  private String quantity;

  private String outOfStockQty;

  private String unitPrice;

  private String amount;

  private String sNCode;

}
