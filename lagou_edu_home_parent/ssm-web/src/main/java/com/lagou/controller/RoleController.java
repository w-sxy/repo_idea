package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
        查询所有角色（条件）
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {

        List<Role> roleList = roleService.findAllRole(role);

        ResponseResult result = new ResponseResult(true, 200, "查询所有角色成功", roleList);
        return result;
    }

    @Autowired
    private MenuService menuService;

    /*
        查询所有的父子菜单信息（分配菜单的第一个接口）
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid() {

        // -1表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);

        ResponseResult result = new ResponseResult(true, 200, "查询所有的父子菜单信息成功", map);
        return result;

    }

    /*
        根据角色id查询关联的菜单信息id
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId) {

        List<Integer> list = roleService.findMenuByRoleId(roleId);

        ResponseResult result = new ResponseResult(true, 200, "查询角色关联的菜单信息id成功", list);
        return result;

    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO) {

        roleService.roleContextMenu(roleMenuVO);

        return new ResponseResult(true,200,"分配菜单成功",null);

    }

    /*
        删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);

        return new ResponseResult(true,200,"删除角色成功",null);

    }

}
