package com.excel.demo.easyexcel.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Dwyane Guo
 * date    2020/10/22
 */
@Data
@ApiModel
public class ResponseWrap<T> {

  private static final String SUCCESS_MESSAGE = "success";

  @ApiModelProperty(value = "错误码")
  private Integer code;
  @ApiModelProperty(value = "提示语")
  private String message;
  @ApiModelProperty(value = "数据")
  private T data;

  public ResponseWrap() {}

  public ResponseWrap(Integer code) {
    this.code = code;
  }

  public ResponseWrap(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public ResponseWrap(Integer code, T data) {
    this.code = code;
    this.data = data;
  }

  public ResponseWrap(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 构造成功 response 结构
   */
  public static ResponseWrap success() {
    ResponseWrap responseWrap = new ResponseWrap<>();
    responseWrap.setCode(1);
    responseWrap.setMessage(SUCCESS_MESSAGE);
    return responseWrap;
  }

  /**
   * 构造成功 response 结构
   */
  public static <D> ResponseWrap<D> success(D data) {
    ResponseWrap<D> responseWrap = new ResponseWrap<>();
    responseWrap.setCode(1);
    responseWrap.setMessage(SUCCESS_MESSAGE);
    responseWrap.setData(data);
    return responseWrap;
  }

  /**
   * 构造失败 response errorCodeEnum data
   */
  public static <D> ResponseWrap error(Integer code, D data) {
    return new ResponseWrap<>(code, data);
  }

  /**
   * 构造失败 response 结构
   */
  public static <D> ResponseWrap<D> error(Integer code, String message) {
    return new ResponseWrap<>(code, message);
  }

  /**
   * 构造失败 response 结构
   */
  public static <D> ResponseWrap<D> error(Integer code, String message, D data) {
    return new ResponseWrap<>(code, message, data);
  }
}
