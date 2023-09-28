package com.massupload.excel.entity;

import jakarta.persistence.*;




@Entity
@Table(name="cat_roles")
public class CatRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="role_name",length = 50,nullable = false)
    private String role_name;

    @Column(name="role_description",length=50,nullable = false)
    private String role_description;

    @Column(name="module",length = 50,nullable = false)
    private String module;

    public CatRolesEntity(String role_name, String role_description, String module) {
        this.role_name = role_name;
        this.role_description = role_description;
        this.module = module;
    }
    public CatRolesEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    @Override
    public String toString() {
        return "CatRolesEntity{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_description='" + role_description + '\'' +
                ", module='" + module + '\'' +
                '}';
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
