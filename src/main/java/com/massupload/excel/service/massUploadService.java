package com.massupload.excel.service;

import com.massupload.excel.DTO.RoleDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface massUploadService {
    public Map<Integer,String> processRoleDetails(List<RoleDetails> roleDetailsList);
}
