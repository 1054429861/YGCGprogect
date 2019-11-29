package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class UserController {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping("/userlogin")
    public String userlogin(HttpSession session, User user,String userloginimgcheck){
        String userloginimgcheckSession = (String) session.getAttribute("userloginimgcheck");//获取登陆生成的验证码
        if (userloginimgcheckSession.equals(userloginimgcheck)) {//输入的验证码和session里面生成的一致
            user = userService.selectOneByUsennameAndUserpwd(user);
            if (user != null) {//登陆成功
                System.out.println(user.getUsername() + user.getUserpwd() + user.getId());
                session.setAttribute("user", user);
                return "redirect:/selectusermenu";
            }
        }
        return "redirect:/jsp/userlogin.jsp";

    }

    @RequestMapping("userloginimgcheck")
    public void userloginimgcheck(HttpSession session, HttpServletResponse response) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(60, 30,
                BufferedImage.TYPE_INT_RGB);// 创建内存图像
        Graphics graphics = bufferedImage.getGraphics();// 获取图形上下文
        graphics.setColor(Color.red);// 设置背景颜色
        // graphics.fillRect(0, 0, 30, 30);
        graphics.setFont(new Font("宋体", 12, 24));

        Random random = new Random();
        int r = random.nextInt(9000) + 1000;
        graphics.drawString(r + "", 6, 20);

        //把生成的验证码数组存入session里面，登陆提交能够获取
        session.setAttribute("userloginimgcheck", r+"");

        graphics.dispose();
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
}
