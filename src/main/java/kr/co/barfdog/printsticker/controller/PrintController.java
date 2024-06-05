package kr.co.barfdog.printsticker.controller;

import kr.co.barfdog.printsticker.model.ExcelData;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PrintController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/label")
    public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws TikaException, IOException { // 2

        List<ExcelData> dataList = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

            Row row = worksheet.getRow(i);

            ExcelData data = new ExcelData();

            int index = (int) row.getCell(0).getNumericCellValue();
            if (index == 0) {
                break;
            }
            data.setIndex(index);
            data.setMerchantUid(row.getCell(1).getStringCellValue());
            data.setOrderStatus(row.getCell(2).getStringCellValue());
            data.setSubscribeStatus(row.getCell(3).getStringCellValue());
            data.setMemberName(row.getCell(5).getStringCellValue());
            data.setDeliveryName(row.getCell(6).getStringCellValue());
            data.setDogType(row.getCell(7).getStringCellValue());
            data.setDogName(row.getCell(8).getStringCellValue());
            data.setDogBirth((int) row.getCell(37).getNumericCellValue());
            data.setDogGender(row.getCell(36).getStringCellValue());
            data.setDogSize(row.getCell(39).getStringCellValue());
            data.setDogNeutralization(row.getCell(41).getStringCellValue());
            data.setDogWeight(row.getCell(40).getNumericCellValue());
            data.setDogStatus(row.getCell(45).getStringCellValue());
            data.setDogActivityLevel(row.getCell(42).getStringCellValue());
            data.setDogSnackCountLevel(row.getCell(46).getStringCellValue());
            data.setDogWalkingCountPerWeek((int) row.getCell(43).getNumericCellValue());
            data.setDogWalkingTimePerOneTime(row.getCell(44).getNumericCellValue());
            data.setDogInedibleFood(row.getCell(47).getStringCellValue());
            data.setDogInedibleFoodEtc(row.getCell(48).getStringCellValue());
            data.setDogCaution(row.getCell(49).getStringCellValue());
            data.setStarterPremium(row.getCell(13).getNumericCellValue());
            data.setTurkeyAndBeef(row.getCell(14).getNumericCellValue());
            data.setDuckAndLamb(row.getCell(15).getNumericCellValue());
            data.setLambAndBeef(row.getCell(16).getNumericCellValue());
            data.setPremiumChicken(row.getCell(17).getNumericCellValue());
            data.setPremiumTurkey(row.getCell(18).getNumericCellValue());
            data.setPremiumLamb(row.getCell(19).getNumericCellValue());
            data.setPremiumBeef(row.getCell(20).getNumericCellValue());
            data.setNumOfPacks((int) row.getCell(10).getNumericCellValue());
            data.setDeliveryInterval((int) row.getCell(32).getNumericCellValue());

            dataList.add(data);
        }

        model.addAttribute("datas", dataList);


        return "frame-4";
    }



}
