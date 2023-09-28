package com.massupload.excel.repository;

import com.massupload.excel.entity.CatRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRolesRepository extends JpaRepository<CatRolesEntity,Long> {
    @Query(value = "SELECT id FROM cat_roles WHERE role_name = :role_name",nativeQuery = true)
    public Long findRoleId(@Param("role_name") String roleName);
}
