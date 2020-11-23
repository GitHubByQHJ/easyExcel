package com.excel.demo.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * @author quehaijun
 * @date 2020/11/17 下午8:13
 **/
@Data
// 头背景设置成绿色 IndexedColors.RED.getIndex()
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 17)
// 头字体设置成10
@HeadFontStyle(fontHeightInPoints = 10)
public class WmsExcelModel extends BaseRowModel {

  private static final long serialVersionUID = 1L;
  //设置背景色为白色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
  @ExcelProperty(value = "NO.", index = 0)
  private String no;

  @ExcelProperty(value = "Delivery bill no.", index = 1)
  private String deliveryBillNo;

  @ExcelProperty(value = "Order Source", index = 2)
  private String orderSource;

  @ExcelProperty(value = "External order  No.", index = 3)
  private String externalOrderNo;

  @ExcelProperty(value = "Status", index = 4)
  private String status;

  @ExcelProperty(value = "Warehouse", index = 5)
  private String warehouse;

  @ExcelProperty(value = "Store name", index = 6)
  private String storeName;

  @ExcelProperty(value = "Creator", index = 7)
  private String creator;

  @ExcelProperty(value = "Created time", index = 8)
  private String createdTime;

  @ExcelProperty(value = "Freight", index = 9)
  private String freight;

  @ExcelProperty(value = "Order amount", index = 10)
  private String orderAmount;

  @ExcelProperty(value = "Address detail", index = 11)
  private String addressDetail;

  @ExcelProperty(value = "District", index = 12)
  private String district;

  @ExcelProperty(value = "City", index = 13)
  private String city;

  @ExcelProperty(value = "Province", index = 14)
  private String province;

  @ExcelProperty(value = "Postal code", index = 15)
  private String postalCode;

  @ExcelProperty(value = "Consignee", index = 16)
  private String consignee;

  @ExcelProperty(value = "Phone Number", index = 17)
  private String phoneNumber;

  @ExcelProperty(value = "Note from buyer", index = 18)
  private String noteFromBuyer;

  @ExcelProperty(value = "Note from seller", index = 19)
  private String noteFromSeller;

  @ExcelProperty(value = "Payment method", index = 20)
  private String paymentMethod;

  @ExcelProperty(value = "Packed time", index = 21)
  private String packedTime;

  @ExcelProperty(value = "Delivery time", index = 22)
  private String deliveryTime;

  @ExcelProperty(value = "Complete Time", index = 23)
  private String completeTime;

  @ExcelProperty(value = "Carrier", index = 24)
  private String carrier;

  @ExcelProperty(value = "Tracking  no.", index = 25)
  private String trackingNo;

  @ExcelProperty(value = "Salesman", index = 26)
  private String salesman;

  //设置背景色为粉色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 14)
  @ExcelProperty(value = "Goods name", index = 27)
  private String goodsName;

  @ExcelProperty(value = "Goods specification", index = 28)
  private String goodsSpecification;

  @ExcelProperty(value = "Barcode", index = 29)
  private String barcode;

  @ExcelProperty(value = "Quantity", index = 30)
  private String quantity;

  @ExcelProperty(value = "Out of stock Qty.", index = 31)
  private String outOfStockQty;

  @ExcelProperty(value = "Unit Price", index = 32)
  private String unitPrice;

  @ExcelProperty(value = "Amount", index = 33)
  private String amount;

  @ExcelProperty(value = "SN Code", index = 34)
  private String sNCode;

}
