package com.lhqs.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhqs.boot.bean.User;
import com.lhqs.boot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TableController {

    @Autowired
    UserService userService;

    //删除用户
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer userId,
                             @RequestParam(value = "pn" ,defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        System.out.println(userId);
        userService.deleteUserById(userId);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @RequestMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }
    @RequestMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                Model model){

        /*List<User> list = userService.list();
        System.out.println(list);*/
        //进行分页,选择分页对象
        //构造分页参数
        /*Page<User>  userPage= new Page<>(pn, 2);
        Page<User> page = userService.page(userPage,null);*/
       /* page.getCurrent(); 当前页
        page.getPages();  总页数
        page.getTotal();  总记录数 */
        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);
        //List<User> records = page.getRecords();
        //遍历的对象为这个page对象的records属性，
        model.addAttribute("pages",page);
        return "table/dynamic_table";
    }
    @RequestMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @RequestMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

}
