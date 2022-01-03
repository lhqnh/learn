package com.lhqs.boot.controller;


import com.lhqs.boot.bean.User;
import com.lhqs.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/lhqs")
@Slf4j
public class IndexController {

/*    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/sql")
    public String jdbcTest(){
        Object o = jdbcTemplate.queryForObject("select count(*) from city",Object.class);
        return o.toString();
    }*/

    @Autowired
    UserService userService;
    //登录页，设置登录页为首页
    @RequestMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    //用户登录
    @RequestMapping("/toIndex")
    public String Index(User user,HttpSession session, Model model){

        User user1 = userService.findUser(user.getUserName());
        //判断登录条件
        log.info("user1={}",user1);
        if(user1 != null){
            //登录成功，重定向页面到index，保存用户的session信息
            if(user1.getPassword().equals(user.getPassword())){
                session.setAttribute("loginUser",user);
                return "redirect:/index.html";
            }
            model.addAttribute("msg","账号密码错误，请重新登录");
            return "login";
        }else {
            //登录失败，返失败信息
            model.addAttribute("msg","请输入正确的用户名");
            //登录失败，返回登录页面
            return "login";
        }
        //登陆成功就重定向到index.html请求

    }


    //登录成功后的地址便为了index.html,刷新就不是进入登录请求了,因为index页面是这个方法进行处理的，
    //index刷新就是进的这个方法
    @RequestMapping("/index.html")
    public String indexPage(HttpSession session){
        /*Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "index";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
        return "index";

    }


}
