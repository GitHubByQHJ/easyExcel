package com.excel.demo.easyexcel.entity;

import java.util.List;
import lombok.Data;

/**
 * @author quehaijun
 * @date 2020/11/20 下午7:02
 */
@Data
public class GoodsDetailVo {

  private String sheet;

  // private Object head;

  private List<GoodsDetail> body;

  // private Object width;
  //
  // private Object explicit;
  //
  // private Object additional;
}
