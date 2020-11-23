package com.excel.demo.easyexcel.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author quehaijun
 * @date 2020/11/17 下午3:40
 */
public class ExcelListener extends AnalysisEventListener<Object> {

  private List<Object> data = new ArrayList<>();
  @Override
  public void invoke(Object o, AnalysisContext analysisContext) {
    data.add(o);
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    System.out.println("所有数据解析完毕");
  }

  public List<Object> getData() {
    return data;
  }

  public void setData(List<Object> data) {
    this.data = data;
  }
}
