package com.massupload.excel.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="rel_user_app_role")
public class RelUserAppRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="role",length = 100,nullable = false)
    private String role;
    @Column(name="assigned_user_id",nullable = false)
    private Long assigned_user_id;
    @Column(name="company",length = 50,nullable = false)
    private String company;
    @Column(name="account",length = 50,nullable = false)
    private String account;
    @Column(name="creation_date",columnDefinition = "TIMESTAMP DEFAULT current_timestamp",nullable = false)
    private Timestamp creation_date;
    @Column(name = "role_id",nullable = false)
    private Long role_id;
    @Column(name="region",length = 50,nullable = false)
    private String region;
    @Column(name="module",length = 50,nullable = false)
    private String module;
    @Column(name="process",length = 50,nullable = false)
    private String process;
    @Column(name="modified_user",length = 50,nullable = false)
    private String modified_user;

    public RelUserAppRoleEntity(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(Long assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getModified_user() {
        return modified_user;
    }

    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    public RelUserAppRoleEntity(String role, Long assigned_user_id, String company, String account, Timestamp creation_date, Long role_id, String region, String module, String process, String modified_user) {
        this.role = role;
        this.assigned_user_id = assigned_user_id;
        this.company = company;
        this.account = account;
        this.creation_date = creation_date;
        this.role_id = role_id;
        this.region = region;
        this.module = module;
        this.process = process;
        this.modified_user = modified_user;
    }
}
