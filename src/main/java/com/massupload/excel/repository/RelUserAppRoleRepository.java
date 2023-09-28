package com.massupload.excel.repository;

import com.massupload.excel.entity.RelUserAppRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelUserAppRoleRepository extends JpaRepository<RelUserAppRoleEntity,Long> {

    @Query(value = "SELECT COUNT(*) FROM rel_user_app_role " +
            "WHERE role = :role AND company = :company AND " +
            "account = :account AND assigned_user_id = :assignedUserId AND " +
            "module = :module AND process = :process",nativeQuery = true)
    int existsIdQuery(@Param("role") String role, @Param("company") String company,
                          @Param("account") String account, @Param("assignedUserId") Long assignedUserId,
                          @Param("module") String module,@Param("process") String process);

//    @Query("DELETE FROM RelUserAppRoleEntity where r.role = :role AND r.company = :company" +
//            "r.account = :account AND" +
//            "r.assigned_user_id = :userId AND" +
//            "r.module = :module AND" +
//            "r.process = :process")
//    void deleteRecordQuery(@Param("userId") Long userId);
    @Modifying
    @Query(value = "DELETE FROM rel_user_app_role " +
            "WHERE role = :role AND company = :company AND " +
            "account = :account AND assigned_user_id = :userId AND " +
            "module = :module AND process = :process",nativeQuery = true)
    void deleteRecordQuery(@Param("role") String role, @Param("company") String company,
                           @Param("account") String account, @Param("userId") Long userId,
                           @Param("module") String module,@Param("process") String process);


//    @Procedure(name = "SO_GRANT_ROLE")
//    void GrantRole(@Param("in_login") String in_login,@Param("in_rolename") String in_rolename,@Param("IN_COMPANY_CODE") String in_company_code,@Param("in_account") String in_account,@Param("in_region") String in_region,@Param("in_loggedinUser") String in_loggedInUser,@Param("in_module") String in_module,@Param("in_process") String in_process);
//
//
//    @Procedure(name="SO_REVOKE_ROLE")
//    void RevokeRole(@Param("in_login") String in_login,@Param("in_rolename") String in_rolename,@Param("IN_COMPANY_CODE") String in_company_code,@Param("in_account") String in_account,@Param("in_region") String in_region,@Param("in_loggedinUser") String in_loggedInUser,@Param("in_module") String in_module,@Param("in_process") String in_process);







}
