package com.excel.demo.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * @author quehaijun
 * @date 2020/11/18 下午2:11
 */
@Data
// 头背景设置成红色 IndexedColors.RED.getIndex()
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 14)
// 头字体设置成10
@HeadFontStyle(fontHeightInPoints = 10)
public class WmsExcelDetailModel extends BaseRowModel {

  private static final long serialVersionUID = 1L;
  //设置背景色为白色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
  @ExcelProperty(value = "NO.", index = 0)
  private String excelIndex;
  //设置背景色为绿色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 17)
  @ExcelProperty(value = "Delivery bill no.", index = 1)
  private String deliverySn;

  @ExcelProperty(value = "Goods name", index = 2)
  private String goodsName;

  @ExcelProperty(value = "Goods specification", index = 3)
  private String specification;

  @ExcelProperty(value = "Barcode", index = 4)
  private String barcode;

  @ExcelProperty(value = "Quantity", index = 5)
  private String goodsNumber;

  @ExcelProperty(value = "External goods code", index = 6)
  private String externalUniqueCode;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "External goods name", index = 7)
  private String externalGoodsName;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "External goods specifications", index = 8)
  private String externalGoodsSpe;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "Goods name", index = 9)
  private String goodsNameChild;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "Goods specification", index = 10)
  private String specificationChild;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "Barcode", index = 11)
  private String barCodeChild;

  //设置背景色为黄色
  @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 13)
  @ExcelProperty(value = "Quantity", index = 12)
  private String goodsNumberChild;

}
