package com.excel.demo.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.excel.demo.easyexcel.entity.GoodsDetail;
import com.excel.demo.easyexcel.entity.GoodsDetailVo;
import com.excel.demo.easyexcel.entity.GoodsInfomationVo;
import com.excel.demo.easyexcel.entity.GoodsInformation;
import com.excel.demo.easyexcel.entity.WmsExcelDetailModel;
import com.excel.demo.easyexcel.entity.WmsExcelModel;
import com.excel.demo.easyexcel.util.ExcelListener;
import com.excel.demo.easyexcel.util.ResponseWrap;
import com.excel.demo.easyexcel.util.WmsExcelListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// import com.flashexpress.fleet.oss.OssUploadResult;
// import com.flashexpress.version.core.constant.ErrorCodeEnum;
// import com.flashexpress.version.core.exception.ServiceEcaException;
// import com.flashexpress.version.core.oss.OssBucketType;
// import com.flashexpress.version.ms.util.WmsExcelListener;

/**
 * @author quehaijun
 * @date 2020/11/13 下午5:57
 */
@Slf4j
//@Transactional(rollbackFor = Exception.class)
@Api(value = "WMS接口", tags = "WMS接口")
@RestController
@RequestMapping("/wmsExcel")
@RequiredArgsConstructor
public class WmsExcelController {

  //private final OssManager ossManager;

  @Value("${base.rpc.impl.temp_file_path}")
  private String tempFilePath;

  @ResponseBody
  @ApiOperation(value = "上传并异步读取Excel表格不同sheet页", notes = "上传并异步读取Excel表格不同sheet页")
  @RequestMapping(value = "/importExcel3", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public ResponseWrap readExcel3(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
    // if (null == file) {
    //   throw new ServiceEcaException(ErrorCodeEnum.C100100);
    // }
    InputStream fileInputStream = null;
    ExcelReader excelReader = null;
    try {
      fileInputStream = new FileInputStream(multipartFileToFile(file));
      excelReader = EasyExcel.read(fileInputStream).build();
      ExcelListener sheet1Listener = new ExcelListener();
      ExcelListener sheet2Listener = new ExcelListener();
      //获取sheet对象
      ReadSheet readSheet1 =
        EasyExcel.readSheet(0).head(WmsExcelModel.class).registerReadListener(sheet1Listener).build();
      ReadSheet readSheet2 =
        EasyExcel.readSheet(1).head(WmsExcelDetailModel.class).registerReadListener(sheet2Listener).build();
      //读取数据
      excelReader.read(readSheet1,readSheet2);
      //业务处理
      System.out.println("sheet1->" + sheet1Listener.getData().size());
      System.out.println("sheet2->" + sheet2Listener.getData().size());
      List<WmsExcelModel> shee1tList = new ArrayList<>();
      int sheet1Size = sheet1Listener.getData().size();
      for (int i = 0; i < sheet1Size; i++) {
        WmsExcelModel sheet1 = (WmsExcelModel) sheet1Listener.getData().get(i);
        shee1tList.add(sheet1);
      }
      List<WmsExcelDetailModel> shee2tList = new ArrayList<>();
      int sheet2Size = sheet2Listener.getData().size();
      for (int i = 0; i < sheet2Size; i++) {
        WmsExcelDetailModel sheet2 = (WmsExcelDetailModel) sheet2Listener.getData().get(i);
        shee2tList.add(sheet2);
      }
      //下载
      doSomething(shee1tList,shee2tList);
      return ResponseWrap.success();
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      fileInputStream.close();
      if (excelReader != null) {
        excelReader.finish();
      }
    }
    return null;
  }

  @ApiOperation("生成Excel")
  @RequestMapping(value = "/operationExcel", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public void operationExcel(String jsonStr) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("开始处理json时间:"+df.format(new Date()));
    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    Matcher m = p.matcher(jsonStr);
    jsonStr = m.replaceAll("");
    System.out.println("开始处理json转JSONObject时间:"+df.format(new Date()));
    JSONArray jsonArr = JSONArray.parseArray(jsonStr);
    JSONObject result = jsonArr.getJSONObject(0);
    JSONObject result2 = jsonArr.getJSONObject(1);
    System.out.println("结束处理json转JSONObject时间:"+df.format(new Date()));
    System.out.println("开始处理JSONObject转JGoodsInfomationVo时间:"+df.format(new Date()));
    GoodsInfomationVo goodsInformation = JSON.toJavaObject(result,GoodsInfomationVo.class);
    System.out.println("结束处理JSONObject转JGoodsInfomationVo时间:"+df.format(new Date()));
    System.out.println("开始处理JSONObject转GoodsDetailVo时间:"+df.format(new Date()));
    GoodsDetailVo goodsDetail = JSON.toJavaObject(result2,GoodsDetailVo.class);
    System.out.println("结束处理JSONObject转GoodsDetailVo时间:"+df.format(new Date()));
    System.out.println("结束处理json时间:"+df.format(new Date()));
    //文件名加时间戳避免并发
    String path = tempFilePath+"/WmsExcel"+System.currentTimeMillis()+".xlsx";
    //文件路径
    File f = new File(path);
    if (!f.getParentFile().exists()) {
      f.getParentFile().mkdirs();
    }
    //指定文件输出位置
    OutputStream outputStream =new FileOutputStream(path);
    ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);
    //将要输出的内容填充到Sheet里
    Sheet sheetOne =new Sheet(1,0, GoodsInformation.class );
    Sheet sheetTwo =new Sheet(2,0, GoodsDetail.class );
    //设置sheet表名
    sheetOne.setSheetName(goodsInformation.getSheet());
    sheetTwo.setSheetName(goodsDetail.getSheet());
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("开始写入Excel时间:"+df.format(new Date()));
    excelWriter.write(goodsInformation.getBody(),sheetOne);
    excelWriter.write(goodsDetail.getBody(),sheetTwo);
    excelWriter.finish();
    outputStream.close();
    System.out.println("结束写入Excel时间:"+df.format(new Date()));
    File file = new File(path);
    InputStream inputStream = new FileInputStream(file);
    //文件上传到阿里云
    // OssUploadResult result3 =
    //   this.ossManager.uploadAndResult(
    //     OssBucketType.UPLOAD_EXCEL.getKeyPrefix(),
    //     file.getName(),
    //     inputStream,
    //     false
    //   );
    // 路径为文件且不为空则进行删除
    if (file.isFile() && file.exists()) {
      file.delete();
    }
  }


  //对数据进行业务处理
  private void doSomething(List<WmsExcelModel> sheet1,List<WmsExcelDetailModel> sheet2) throws Exception {
    System.out.println("获取数据量为:"+sheet1.size());
     Map<String,Object> map = new HashMap<>();
     map.put("WmsExcelModel",sheet1);
     map.put("WmsExcelDetailModel",sheet2);
    String str = JSONObject.toJSONString(map);
    System.out.println(str);
    Map maps= JSON.parseObject(str);
    String bbb = JSONObject.toJSONString(maps.get("WmsExcelDetailModel"));
    System.out.println(bbb);
    List<WmsExcelDetailModel> list = JSON.parseArray(bbb, WmsExcelDetailModel.class);
    //文件路径
    File f = new File("version-ms/src/main/resources/tempFile");
    //打印出相对路径
    String path = f.getAbsolutePath()+"/WmsExcel.xlsx";
    //System.out.println(f.getAbsolutePath());
    // }
    //指定文件输出位置
    OutputStream outputStream =new FileOutputStream(path);
    ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);
    //将要输出的内容填充到Sheet里
    Sheet sheetOne =new Sheet(1,0,WmsExcelModel.class );
    Sheet sheetTwo =new Sheet(2,0,WmsExcelDetailModel.class );
    //设置sheet表名
    sheetOne.setSheetName("Goods information");
    sheetTwo.setSheetName("Set details");
    /**
     * 写数据到Write上下文中
     * 第一个参数：要写入的内容
     * 第二个参数：要写入的sheet目标
     */
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("开始写入Excel时间:"+df.format(new Date()));
    excelWriter.write(sheet1,sheetOne);
    excelWriter.write(sheet2,sheetTwo);
    excelWriter.finish();
    outputStream.close();
    System.out.println("结束写入Excel时间:"+df.format(new Date()));
    File file = new File(path);
    // 路径为文件且不为空则进行删除
    if (file.isFile() && file.exists()) {
      file.delete();
    }
  }


  @ResponseBody
  @ApiOperation(value = "上传并异步读取Excel表格", notes = "上传并异步读取Excel表格-大文件")
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public ResponseWrap readExcel(@RequestParam("file") MultipartFile file) throws Exception {
    // if (null == file) {
    //   throw new ServiceEcaException(ErrorCodeEnum.C100100);
    // }
    Sheet sheet = new Sheet(1, 1, WmsExcelModel.class);
    InputStream fileInputStream = new FileInputStream(multipartFileToFile(file));
    EasyExcelFactory.readBySax(fileInputStream,sheet,new WmsExcelListener());
    return ResponseWrap.success();
  }


  /**
   * MultipartFile转file
   **/
  public static File multipartFileToFile(MultipartFile file) throws Exception {
    File toFile = null;
    if (file.equals("") || file.getSize() <= 0) {
      file = null;
    } else {
      InputStream ins = null;
      ins = file.getInputStream();
      toFile = new File(file.getOriginalFilename());
      inputStreamToFile(ins, toFile);
      ins.close();
    }
    return toFile;
  }

  public static void inputStreamToFile(InputStream ins, File file) {
    try {
      OutputStream os = new FileOutputStream(file);
      int bytesRead = 0;
      byte[] buffer = new byte[8192];
      while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
        os.write(buffer, 0, bytesRead);
      }
      os.close();
      ins.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
