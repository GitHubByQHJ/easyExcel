package com.excel.demo.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author quehaijun
 * @date 2020/11/13 下午5:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserExcelModel extends BaseRowModel {

  private static final long serialVersionUID = 1L;

  @ExcelProperty(value = "用户id", index = 0)
  private Integer id;

  @ExcelProperty(value = "用户名", index = 1)
  private String name;

  @ExcelProperty(value = "密码", index = 2)
  private String password;

  @ExcelProperty(value = "电话", index = 3)
  private String phone;

  @ExcelProperty(value = "超级管理员", index = 4)
  private Boolean superAdmin;

  @ExcelProperty(value = "是否删除", index = 5)
  private Boolean deleted;

  @ExcelProperty(value = "操作人id", index = 6)
  private Integer operatorId;

  @ExcelProperty(value = "测试字段1", index = 7)
  private String test1;

  @ExcelProperty(value = "测试字段2", index = 8)
  private String test2;

  @ExcelProperty(value = "测试字段3", index = 9)
  private String test3;

  @ExcelProperty(value = "测试字段4", index = 10)
  private String test4;

  @ExcelProperty(value = "测试字段5", index = 11)
  private String test5;

  @ExcelProperty(value = "测试字段6", index = 12)
  private String test6;

  @ExcelProperty(value = "测试字段7", index = 13)
  private String test7;

  @ExcelProperty(value = "测试字段8", index = 14)
  private String test8;

  @ExcelProperty(value = "测试字段9", index = 15)
  private String test9;

  @ExcelProperty(value = "测试字段10", index = 16)
  private String test10;

  @ExcelProperty(value = "测试字段11", index = 17)
  private String test11;

  @ExcelProperty(value = "测试字段12", index = 18)
  private String test12;

  @ExcelProperty(value = "测试字段13", index = 19)
  private String test13;

  @ExcelProperty(value = "测试字段14", index = 20)
  private String test14;

  @ExcelProperty(value = "测试字段15", index = 22)
  private String test15;

  @ExcelProperty(value = "测试字段16", index = 23)
  private String test16;

  @ExcelProperty(value = "测试字段17", index = 24)
  private String test17;

  @ExcelProperty(value = "测试字段18", index = 25)
  private String test18;

  @ExcelProperty(value = "测试字段19", index = 26)
  private String test19;

  @ExcelProperty(value = "测试字段20", index = 27)
  private String test20;
}
