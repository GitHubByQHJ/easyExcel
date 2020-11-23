package com.excel.demo.easyexcel.entity;

import java.util.List;
import lombok.Data;

/**
 * @author quehaijun
 * @date 2020/11/20 下午6:02
 */
@Data
public class GoodsInfomationVo {

  private String sheet;

  // private Object head;

  private List<GoodsInformation> body;

  // private Object width;
  //
  // private Object explicit;
  //
  // private Object additional;

}
