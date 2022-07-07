package jdbc.bankmanage.admin.menu;

import jdbc.bankmanage.admin.model.Admin;

import static jdbc.bankmanage.admin.controller.AdminController.adminController;
import static jdbc.bankmanage.admin.controller.AdminLoginMenu.adminLoginMenu;



public class AdminMenu {

    public static void adminMenu(){
        //先登录
        //若输入错误超过五次则自动返回上一级菜单
        Admin admin = adminLoginMenu();
        if( admin==null )   return;

        //登录成功
        System.out.println("****欢迎****\n"+"管理员："+admin.getAdminID()+"  "+admin.getAdminName());

        while (true){
            System.out.println("\n功能选择：\n\t1. 查询个人用户信息");
            System.out.println("\t2. 增加个人用户账户");
            System.out.println("\t3. 删除个人用户账户");
            System.out.println("\t4.检索所有个人用户");
            System.out.println("\t5.用户余额人民币转外币");
            System.out.println("\t6.用户余额外币转人民币");
            System.out.println("\t7. 退出登录");
            if( adminController() ) break;
        }

        //退出登录
        System.out.println("祝您生活愉快");
    }

}
