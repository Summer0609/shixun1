package jdbc.bankmanage.admin.controller;

import jdbc.bankmanage.admin.model.Admin;
import jdbc.bankmanage.admin.service.AdminService;

import java.util.Scanner;

public class AdminLoginMenu {
    public static Admin adminLoginMenu(){
        Scanner reader = new Scanner(System.in);
        Admin admin;
        for(int i=0; i<5; i++){
            System.out.println("****请先登录****");
            System.out.println("请输入管理员id：");
            String id = reader.next();
            System.out.println("请输入密码：");
            String password = reader.next();
            admin = AdminService.logIn(id, password);
            if( admin!=null )   return admin;
        }
        return null;    //返回上级菜单
    }
}
