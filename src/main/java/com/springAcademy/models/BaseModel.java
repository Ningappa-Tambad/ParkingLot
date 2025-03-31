package com.springAcademy.models;

import java.util.Date;

public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastupdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastupdatedAt() {
        return lastupdatedAt;
    }

    public void setLastupdatedAt(Date lastupdatedAt) {
        this.lastupdatedAt = lastupdatedAt;
    }
}
