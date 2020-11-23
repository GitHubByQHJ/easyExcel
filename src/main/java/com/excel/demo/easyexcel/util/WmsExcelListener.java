package com.excel.demo.easyexcel.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.excel.demo.easyexcel.entity.WmsExcelModel;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.SneakyThrows;

/**
 * @author quehaijun
 * @date 2020/11/17 下午3:40
 */
public class WmsExcelListener extends AnalysisEventListener<Object> {

  private List<Object> list = new ArrayList<Object>();
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  public void invoke(Object data, AnalysisContext analysisContext) {
    if(0 == list.size()){
      System.out.println("开始解析Excel时间:"+df.format(new Date()));
    }
    //System.out.println("解析到一条数据:{ "+ data.toString() +" }");
    list.add(data);
    //System.out.println("数据大小："+list.size());
  }


  @Override
  @SneakyThrows
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    System.out.println("所有数据解析完毕");
    System.out.println("结束解析Excel时间:"+df.format(new Date()));
    //doSomething(list);
  }

  //对数据进行业务处理
  private void doSomething(List<WmsExcelModel> dataList) throws Exception {
    System.out.println("获取数据量为:"+dataList.size());
    //指定文件输出位置
    OutputStream outputStream =new FileOutputStream("/Users/apple/Downloads/conf/WmsExcel.xlsx");
    ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);
    //将要输出的内容填充到Sheet里
    Sheet sheet =new Sheet(1,0,WmsExcelModel.class );
    //设置sheet表名
    sheet.setSheetName("Goods information");
    //TableStyle tableStyle = new TableStyle();
    //tableStyle.setTableHeadBackGroundColor(IndexedColors.YELLOW);
    //tableStyle.setTableContentBackGroundColor(IndexedColors.ROYAL_BLUE);
    //sheet.setTableStyle(tableStyle);
    /**
     * 写数据到Write上下文中
     * 第一个参数：要写入的内容
     * 第二个参数：要写入的sheet目标
     */
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("开始写入Excel时间:"+df.format(new Date()));
    excelWriter.write(dataList,sheet);
    excelWriter.finish();
    outputStream.close();
    System.out.println("结束写入Excel时间:"+df.format(new Date()));
  }

}
