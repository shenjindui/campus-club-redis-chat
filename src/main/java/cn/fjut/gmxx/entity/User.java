package cn.fjut.gmxx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 */
public class User implements Serializable {

    private Long id;

    private String name;

    private String avatar;

    public void setName(String name) {
        this.name = name.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
