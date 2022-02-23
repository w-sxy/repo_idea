package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*
        查询所有菜单信息
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {

        List<Menu> menuList = menuService.findAllMenu();

        return new ResponseResult(true,200,"查询所有菜单信息成功",menuList);

    }

    /*
        回显菜单信息
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id) {

        // 根据id的值判断是更新还是添加操作  判断id的值是否为-1
        if (id == -1) {
            // 添加  回显信息中不需要查询menu信息
            List<Menu> list = menuService.findSubMenuListByPid(-1);

            // 封装数据
            HashMap<String, Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",list);

            return new ResponseResult(true,200,"添加回显成功",map);

        } else {

            // 修改  回显所有的menu信息
            Menu menu = menuService.findMenuById(id);

            List<Menu> list = menuService.findSubMenuListByPid(-1);
            HashMap<String, Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",list);

            return new ResponseResult(true,200,"修改回显成功",map);

        }


    }

}
