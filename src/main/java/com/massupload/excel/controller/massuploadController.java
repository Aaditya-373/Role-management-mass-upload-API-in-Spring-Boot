package com.massupload.excel.controller;


import java.io.IOException;
import java.util.*;


import com.massupload.excel.DTO.RoleDetails;
import com.massupload.excel.service.massUploadService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/rolemanagement")
public class massuploadController{
    @Autowired
    private massUploadService service;

    public massuploadController(massUploadService service) {
        this.service = service;
    }

    @PostMapping("/massupload")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {

            if (file.isEmpty() || !(file.getOriginalFilename().endsWith(".xlsx"))) {
                return ResponseEntity.badRequest().body("Empty file (or) Invalid file format");
            }
            List<Map<String, String>> excelData = new ArrayList<>();
            try(XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
                int no_sheets = workbook.getNumberOfSheets();
                for (int s = 0; s < no_sheets; s++) {
                    XSSFSheet sheet = workbook.getSheetAt(s);
                    int no_col = sheet.getRow(0).getLastCellNum();
                    int no_row = sheet.getLastRowNum();
                    List<String> acceptedHeaders = Arrays.asList(
                            "Assigned user login",
                            "Company",
                            "Account",
                            "Role",
                            "Module",
                            "Region",
                            "Process",
                            "Type"
                    );
                    List<String> headers = new ArrayList<>();
                    List<RoleDetails> roleDetails = new ArrayList<>();
                    XSSFRow headerRow = sheet.getRow(0);
                    for (int i = 0; i < no_col; i++) {
                        headers.add(headerRow.getCell(i).toString());
                    }
                    for (int i = 0; i < acceptedHeaders.size(); i++) {
                        if (!acceptedHeaders.get(i).equalsIgnoreCase(headers.get(i))) {
                            //then throw an exception:columns not in correct format
                            return ResponseEntity.badRequest().body("Rows are not in correct format");
                        }

                    }

                    for (int r = 1; r <= no_row; r++) {
                        Row row = sheet.getRow(r);
                        Map<String, String> rowData = new HashMap<>();
                        for (int c = 0; c < no_col; c++) {
                            Cell cell = row.getCell(c);
                            String header = headers.get(c);
                            String cellVal = cell != null ? cell.toString() : "";
                            rowData.put(header, cellVal);
                        }
                        excelData.add(rowData);
                    }

                }
                ArrayList<RoleDetails> roleDetails = new ArrayList<>();
                for (Map<String, String> map : excelData) {
                    String role = map.get("Role");
                    String assignedUser = map.get("Assigned User Login");
                    String company = map.get("Company");
                    String account = map.get("Account");
                    String module = map.get("Module");
                    String region = map.get("Region");
                    String process = map.get("Process");
                    String type = map.get("Type");
                    RoleDetails roleDetail = new RoleDetails(role, assignedUser, company, account, region, module, process, type);
                    roleDetails.add(roleDetail);
                }
                Map<Integer, String> errorMap = service.processRoleDetails(roleDetails);

//                return ResponseEntity.ok(roleDetails);
//          }
                if (!errorMap.isEmpty()) {
                    return ResponseEntity.badRequest().body(errorMap);

                } else {
                    Map<String,String> successResponse = new HashMap<>();
                    successResponse.put("message","Success");
                    return ResponseEntity.ok(successResponse);

//                    return ResponseEntity.ok("Success");
                }

            }
    }

}
