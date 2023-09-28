package com.massupload.excel.service;

import com.massupload.excel.DTO.RoleDetails;
import com.massupload.excel.entity.RelUserAppRoleEntity;
import com.massupload.excel.repository.CatRolesRepository;
import com.massupload.excel.repository.RelUserAppRoleRepository;
import com.massupload.excel.repository.SoVwCatUsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Transactional
@Service
public class massUploadServiceImpl implements massUploadService{


    RelUserAppRoleRepository relUserAppRoleRepository;

    SoVwCatUsersRepository soVwCatUsersRepository;
    CatRolesRepository catRolesRepository;

    public massUploadServiceImpl(RelUserAppRoleRepository relUserAppRoleRepository, SoVwCatUsersRepository soVwCatUsersRepository, CatRolesRepository catRolesRepository) {
        this.relUserAppRoleRepository = relUserAppRoleRepository;
        this.soVwCatUsersRepository = soVwCatUsersRepository;
        this.catRolesRepository = catRolesRepository;
    }


    @Override
    public Map<Integer,String> processRoleDetails(List<RoleDetails> roleDetailsList) {
        Map<Integer,String> errorMap = new HashMap<>();
        for(int i = 0;i<roleDetailsList.size();i++) {
            RoleDetails roleDetails = roleDetailsList.get(i);
            Long userId = soVwCatUsersRepository.findUserId(roleDetails.getAssignedUser());
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            if (userId != null) {
                int count = relUserAppRoleRepository.existsIdQuery(roleDetails.getRole(), roleDetails.getCompany(), roleDetails.getAccount(), userId, roleDetails.getModule(), roleDetails.getProcess());
                if (roleDetails.getType().equalsIgnoreCase("Grant")) {
                    if (count == 0) {
                        Long roleId = catRolesRepository.findRoleId(roleDetails.getRole());
                        RelUserAppRoleEntity RelUserAppRole = new RelUserAppRoleEntity(roleDetails.getRole(), userId, roleDetails.getCompany(), roleDetails.getAccount(), currentTimestamp, roleId, roleDetails.getRegion(), roleDetails.getModule(), roleDetails.getProcess(), "John");
                        relUserAppRoleRepository.save(RelUserAppRole);
                        //invoke procedure SO_GRANT_ROLE
//                        relUserAppRoleRepository.GrantRole(
//                                roleDetails.getAssignedUser(),
//                                roleDetails.getRole(),
//                                roleDetails.getCompany(),
//                                roleDetails.getAccount(),
//                                roleDetails.getRegion(),
//                                "John",
//                                roleDetails.getModule(),
//                                roleDetails.getProcess()
//                        );
                    }else if(count>0){

                        errorMap.put(i + 1, "Error at line " + (i + 2) + " of excel file:Unable to Grant,Role already exists for this user");
                    }
                }
                else {
                    if (count > 0) {
                        relUserAppRoleRepository.deleteRecordQuery(roleDetails.getRole(), roleDetails.getCompany(), roleDetails.getAccount(), userId, roleDetails.getModule(), roleDetails.getProcess());
                        //invoke procedure SO_REVOKE_ROLE
//                        relUserAppRoleRepository.RevokeRole(
//                                roleDetails.getAssignedUser(),
//                                roleDetails.getRole(),
//                                roleDetails.getCompany(),
//                                roleDetails.getAccount(),
//                                roleDetails.getRegion(),
//                                "John",
//                                roleDetails.getModule(),
//                                roleDetails.getProcess()
//                        );
                    }
                    else{
                        errorMap.put(i + 1, "Error at line " + (i + 2) + " of excel file:Unable to Revoke,Role does not exist for this user");
                    }
                }
            }
        }
        return errorMap;
    }
}
