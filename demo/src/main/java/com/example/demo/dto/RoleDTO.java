package com.example.demo.dto;

public class RoleDTO {
    private int id;
    private String roleName;
    private String desc;

    public RoleDTO() {
    }

    public RoleDTO(int id, String roleName, String desc) {
        this.id = id;
        this.roleName = roleName;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
