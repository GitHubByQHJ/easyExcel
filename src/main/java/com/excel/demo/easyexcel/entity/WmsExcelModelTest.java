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
public class WmsExcelModelTest extends BaseRowModel {

  private static final long serialVersionUID = 1L;
  //设置背景色为白色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
  @ExcelProperty(value = "NO.", index = 0)
  private String a;

  @ExcelProperty(value = "Delivery bill no.", index = 1)
  private String b;

  @ExcelProperty(value = "Order Source", index = 2)
  private String c;

  @ExcelProperty(value = "External order  No.", index = 3)
  private String d;

  @ExcelProperty(value = "Status", index = 4)
  private String e;

  @ExcelProperty(value = "Warehouse", index = 5)
  private String f;

  @ExcelProperty(value = "Store name", index = 6)
  private String g;

  @ExcelProperty(value = "Creator", index = 7)
  private String h;

  @ExcelProperty(value = "Created time", index = 8)
  private String i;

  @ExcelProperty(value = "Freight", index = 9)
  private String j;

  @ExcelProperty(value = "Order amount", index = 10)
  private String k;

  @ExcelProperty(value = "Address detail", index = 11)
  private String l;

  @ExcelProperty(value = "District", index = 12)
  private String m;

  @ExcelProperty(value = "City", index = 13)
  private String n;

  @ExcelProperty(value = "Province", index = 14)
  private String o;

  @ExcelProperty(value = "Postal code", index = 15)
  private String p;

  @ExcelProperty(value = "Consignee", index = 16)
  private String q;

  @ExcelProperty(value = "Phone Number", index = 17)
  private String r;

  @ExcelProperty(value = "Note from buyer", index = 18)
  private String s;

  @ExcelProperty(value = "Note from seller", index = 19)
  private String t;

  @ExcelProperty(value = "Payment method", index = 20)
  private String u;

  @ExcelProperty(value = "Packed time", index = 21)
  private String v;

  @ExcelProperty(value = "Delivery time", index = 22)
  private String w;

  @ExcelProperty(value = "Complete Time", index = 23)
  private String x;

  @ExcelProperty(value = "Carrier", index = 24)
  private String y;

  @ExcelProperty(value = "Tracking  no.", index = 25)
  private String z;

  @ExcelProperty(value = "Salesman", index = 26)
  private String aa;

  //设置背景色为粉色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 14)
  @ExcelProperty(value = "Goods name", index = 27)
  private String ab;

  @ExcelProperty(value = "Goods specification", index = 28)
  private String ac;

  @ExcelProperty(value = "Barcode", index = 29)
  private String ad;

  @ExcelProperty(value = "Quantity", index = 30)
  private String ae;

  @ExcelProperty(value = "Out of stock Qty.", index = 31)
  private String af;

  @ExcelProperty(value = "Unit Price", index = 32)
  private String ag;

  @ExcelProperty(value = "Amount", index = 33)
  private String ah;

  @ExcelProperty(value = "SN Code", index = 34)
  private String ai;
}
