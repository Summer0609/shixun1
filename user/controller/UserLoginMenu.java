package jdbc.bankmanage.user.controller;

import jdbc.bankmanage.user.model.User;
import jdbc.bankmanage.user.service.LogIn;

import java.util.Scanner;

public class UserLoginMenu {
    public static User userLoginMenu(){
        Scanner reader = new Scanner(System.in);
        User user;
        for(int i=0; i<5; i++){
            System.out.println("****请先登录****");
            System.out.println("请输入用户id：");
            String id = reader.next();
            System.out.println("请输入密码：");
            String password = reader.next();
            user =LogIn.userLogIn(id, password);
            if( user!=null )   return user;
        }
        return null;    //返回上级菜单
    }
}
