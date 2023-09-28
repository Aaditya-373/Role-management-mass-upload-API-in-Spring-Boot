package com.massupload.excel.DTO;

public class RoleDetails {
    private String role;
    private String assignedUser;
    private String company;
    private String account;
    private String region;
    private String module;
    private String process;
    private String type;

    @Override
    public String toString() {
        return "RoleDetails{" +
                "role='" + role + '\'' +
                ", assignedUser='" + assignedUser + '\'' +
                ", company='" + company + '\'' +
                ", account='" + account + '\'' +
                ", region='" + region + '\'' +
                ", module='" + module + '\'' +
                ", process='" + process + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RoleDetails(String role, String assignedUser, String company, String account, String region, String module, String process, String type) {
        this.role = role;
        this.assignedUser = assignedUser;
        this.company = company;
        this.account = account;
        this.region = region;
        this.module = module;
        this.process = process;
        this.type = type;
    }
}
