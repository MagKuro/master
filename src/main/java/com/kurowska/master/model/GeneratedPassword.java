package com.kurowska.master.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GeneratedPassword implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String password;
    private String md5;
    private String sha1;
    private String sha2;

    public GeneratedPassword() {
    }

    public GeneratedPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5Hash) {
        this.md5 = md5Hash;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1Hash) {
        this.sha1 = sha1Hash;
    }

    public String getSha2() {
        return sha2;
    }

    public void setSha2(String sha2) {
        this.sha2 = sha2;
    }
}
