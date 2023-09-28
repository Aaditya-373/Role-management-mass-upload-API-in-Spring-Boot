package com.massupload.excel.entity;

import jakarta.persistence.*;

@Entity
@Table(name="so_vw_cat_users")
public class SoVwCatUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="LOGIN",length = 50,nullable = false)
    private String login;

    @Column(name="FULL_NAME",length = 250,nullable = false)
    private String full_name;
    @Column(name="MAIL",length=250,nullable = false)
    private String mail;
    @Column(name="NET_LOGIN",length=10,nullable = false)
    private String netlogin;
    @Column(name="active",length=1,nullable = false)
    private String active;

    @Override
    public String toString() {
        return "SoVwCatUsers{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", full_name='" + full_name + '\'' +
                ", mail='" + mail + '\'' +
                ", netlogin='" + netlogin + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

    public SoVwCatUsers(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNetlogin() {
        return netlogin;
    }

    public void setNetlogin(String netlogin) {
        this.netlogin = netlogin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public SoVwCatUsers(String login, String full_name, String mail, String netlogin, String active) {
        this.login = login;
        this.full_name = full_name;
        this.mail = mail;
        this.netlogin = netlogin;
        this.active = active;
    }
}
