package com.lagou.domain;

import java.util.List;

public class RoleMenuVO {

    private Integer roleId;
    private List<Integer> menuIdList;

    @Override
    public String toString() {
        return "RoleMenuVO{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }
}
