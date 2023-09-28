package com.massupload.excel.repository;

import com.massupload.excel.entity.SoVwCatUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoVwCatUsersRepository extends JpaRepository<SoVwCatUsers,Long> {
    @Query(value = "SELECT id FROM so_vw_cat_users WHERE login = :assignedUser",nativeQuery = true)
    public Long findUserId(@Param("assignedUser") String assignedUser);

}
