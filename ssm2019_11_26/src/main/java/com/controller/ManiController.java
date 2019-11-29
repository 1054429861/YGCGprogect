package com.controller;

import com.domain.Menu;
import com.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManiController {
    @Resource(name = "menuServiceImpl")
    MenuService menuService;

    /**
     * 查询当前登陆用户的菜单
     * @return
     */
    @RequestMapping("/selectusermenu")
    public ModelAndView selectUserMenu(HttpSession session) throws JsonProcessingException {
        ModelAndView modelAndView=new ModelAndView();

        //模拟用户从登陆的session里面获取的
       User user= (User) session.getAttribute("user");

        //根据当前登陆用用户的id获取用户的菜单list集合
        List<Menu> menus = menuService.selectUserMenu(user);

        ObjectMapper objectMapper=new ObjectMapper();
        String menusJson=objectMapper.writeValueAsString(menus);//把用户的菜单list集合转换为json格式

        menusJson = menusJson.replaceAll("\"pid\"", "\"pId\"");//把json格式里面的pid替换成pId，为了在生成树的时候名字一致
        modelAndView.addObject("menusJson",menusJson);//加入作用域
        modelAndView.setViewName("main");//设置视图
        return modelAndView;
    }
}
