package com.excel.demo.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.excel.demo.easyexcel.entity.Excel;
import com.excel.demo.easyexcel.entity.UserExcelModel;
import com.excel.demo.easyexcel.util.ExcelListener;
import com.excel.demo.easyexcel.util.ExcelUtils;
import com.excel.demo.easyexcel.util.ResponseWrap;
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
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author quehaijun
 * @date 2020/11/13 下午5:57
 */
@Slf4j
// @Transactional(rollbackFor = Exception.class)
@Api(value = "用户接口2", tags = "用户接口2")
@RestController
@AllArgsConstructor
@RequestMapping("/user2")
public class ExcelTest2 {

  // private final ExcelDao excelDao;

  @ResponseBody
  @ApiOperation(value = "上传并异步读取Excel表格不同sheet页", notes = "上传并异步读取Excel表格不同sheet页")
  @RequestMapping(value = "/importExcel3", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public ResponseWrap readExcel3(@RequestParam("file") MultipartFile file) throws Exception {
    // if (null == file) {
    //   throw new ServiceEcaException(ErrorCodeEnum.C100100);
    // }
    InputStream fileInputStream = new FileInputStream(multipartFileToFile(file));
    ExcelReader excelReader = EasyExcel.read(fileInputStream).build();
    ExcelListener sheetListener = new ExcelListener();
    //获取sheet对象
    ReadSheet readSheet =
      EasyExcel.readSheet(0).head(UserExcelModel.class).registerReadListener(sheetListener).build();
    //读取数据
    excelReader.read(readSheet);
    //业务处理
    System.out.println("sheet->" + sheetListener.getData().size());
    List<UserExcelModel> sheetList = new ArrayList<>();
    int sheetSize = sheetListener.getData().size();
    for (int i = 0; i < sheetSize; i++) {
      UserExcelModel result = new UserExcelModel();
      result.setId(((UserExcelModel) sheetListener.getData().get(i)).getId());
      result.setName(((UserExcelModel) sheetListener.getData().get(i)).getName());
      result.setPassword(((UserExcelModel) sheetListener.getData().get(i)).getPassword());
      result.setPhone(((UserExcelModel) sheetListener.getData().get(i)).getPhone());
      result.setSuperAdmin(((UserExcelModel) sheetListener.getData().get(i)).getSuperAdmin());
      result.setDeleted(((UserExcelModel) sheetListener.getData().get(i)).getDeleted());
      result.setOperatorId(((UserExcelModel) sheetListener.getData().get(i)).getOperatorId());
      result.setTest1(((UserExcelModel) sheetListener.getData().get(i)).getTest1());
      result.setTest2(((UserExcelModel) sheetListener.getData().get(i)).getTest2());
      result.setTest3(((UserExcelModel) sheetListener.getData().get(i)).getTest3());
      result.setTest4(((UserExcelModel) sheetListener.getData().get(i)).getTest4());
      result.setTest5(((UserExcelModel) sheetListener.getData().get(i)).getTest5());
      result.setTest6(((UserExcelModel) sheetListener.getData().get(i)).getTest6());
      result.setTest7(((UserExcelModel) sheetListener.getData().get(i)).getTest7());
      result.setTest8(((UserExcelModel) sheetListener.getData().get(i)).getTest8());
      result.setTest9(((UserExcelModel) sheetListener.getData().get(i)).getTest9());
      result.setTest10(((UserExcelModel) sheetListener.getData().get(i)).getTest10());
      result.setTest11(((UserExcelModel) sheetListener.getData().get(i)).getTest11());
      result.setTest12(((UserExcelModel) sheetListener.getData().get(i)).getTest12());
      result.setTest13(((UserExcelModel) sheetListener.getData().get(i)).getTest13());
      result.setTest14(((UserExcelModel) sheetListener.getData().get(i)).getTest14());
      result.setTest15(((UserExcelModel) sheetListener.getData().get(i)).getTest15());
      result.setTest16(((UserExcelModel) sheetListener.getData().get(i)).getTest16());
      result.setTest17(((UserExcelModel) sheetListener.getData().get(i)).getTest17());
      result.setTest18(((UserExcelModel) sheetListener.getData().get(i)).getTest18());
      result.setTest19(((UserExcelModel) sheetListener.getData().get(i)).getTest19());
      result.setTest20(((UserExcelModel) sheetListener.getData().get(i)).getTest20());
      sheetList.add(result);
    }
    return ResponseWrap.success(sheetList);
  }


  @ResponseBody
  @ApiOperation(value = "上传并异步读取Excel表格", notes = "上传并异步读取Excel表格-大文件")
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public ResponseWrap readExcel(@RequestParam("file") MultipartFile file) throws Exception {
    // if (null == file) {
    //   throw new ServiceEcaException(ErrorCodeEnum.C100100);
    // }
    Sheet sheet = new Sheet(1, 1, UserExcelModel.class);
    InputStream fileInputStream = new FileInputStream(multipartFileToFile(file));
    EasyExcelFactory.readBySax(fileInputStream,sheet,new ExcelListener());
    return ResponseWrap.success();
  }

  /**
   * 适合读取小文件不超过10000行
   **/
  @ResponseBody
  @ApiOperation(value = "上传并读取Excel表格", notes = "上传并读取Excel表格,适合读取小文件不超过10000行")
  @RequestMapping(value = "/importExcelSmall", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
  public ResponseWrap readExcelSmall(@RequestParam("file") MultipartFile file) throws Exception {
    // if (null == file) {
    //   throw new ServiceEcaException(ErrorCodeEnum.C100100);
    // }
    Sheet sheet = new Sheet(1, 1, UserExcelModel.class);
    InputStream fileInputStream = new FileInputStream(multipartFileToFile(file));
    List<Object> read1 = EasyExcelFactory.read(fileInputStream, sheet);
    // 存 ExcelMode 实体的 集合
    List<UserExcelModel> list = new ArrayList<UserExcelModel>();
    for (Object o : read1) {
      list.add((UserExcelModel) o);
    }
    return ResponseWrap.success(list);
  }


  @ApiOperation(value = "向Excel写入数据并导出到指定位置", notes = "向Excel写入数据并导出到指定位置")
  @RequestMapping(value = "/exprotExcel", method = RequestMethod.POST)
  public void  ExportTest() throws IOException {
    // 查符合筛选条件的数据
    //List<Excel> list = excelDao.getExcel();
    List<Excel> list = new ArrayList<>();
    List<UserExcelModel> dataList = new ArrayList<>();
    // 把符合条件的数据，转化成写excel需要的Model实体
    for(int i = 0; i < list.size(); i++){
      UserExcelModel userExcelModel = new UserExcelModel();
      BeanUtils.copyProperties(list.get(i),userExcelModel);
      dataList.add(userExcelModel);
    }
    System.out.println("获取数据量为:"+dataList.size());
    //指定文件输出位置
    OutputStream outputStream =new FileOutputStream("/Users/apple/Downloads/conf/myexcel3.xlsx");
    ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);
    //将要输出的内容填充到Sheet里
    Sheet sheet =new Sheet(1,0,UserExcelModel.class );
    //设置sheet表名
    sheet.setSheetName("my_three_excel");
    TableStyle tableStyle = new TableStyle();
    tableStyle.setTableHeadBackGroundColor(IndexedColors.YELLOW);
    tableStyle.setTableContentBackGroundColor(IndexedColors.ROYAL_BLUE);
    sheet.setTableStyle(tableStyle);
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

  @ApiOperation(value = "向Excel写入数据并下载", notes = "向Excel写入数据并下载")
  @ResponseBody
  @RequestMapping(value = "/exprotExcel2",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
  public void exportPromotionByExcel(HttpServletResponse response) {
    try {
      // 查符合筛选条件的数据
      //List<Excel> list = excelDao.getExcel();
      List<Excel> list = new ArrayList<>();
      List<UserExcelModel> modelList = new ArrayList<>();
      // 把符合条件的数据，转化成写excel需要的Model实体
      for(int i = 0; i < list.size(); i++){
        UserExcelModel userExcelModel = new UserExcelModel();
        BeanUtils.copyProperties(list.get(i),userExcelModel);
        modelList.add(userExcelModel);
      }
      String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
      // 指定导出的excel文件的名字
      String fileName = "promotion_export_" + time;
      // 指定工作簿的名字
      String sheetName = "sheet1";
      // easyexcel工具类实现Excel文件导出
      ExcelUtils.writeExcel(response, modelList, fileName, sheetName, new UserExcelModel());
    } catch (Exception e) {
      e.printStackTrace();
      log.error("exportPromotionByExcel error:", e);
    }
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
