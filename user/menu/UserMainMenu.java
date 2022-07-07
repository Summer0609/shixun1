package jdbc.bankmanage.user.menu;

import jdbc.bankmanage.user.controller.ControlPanel;
import jdbc.bankmanage.user.model.User;
import  jdbc.bankmanage.user.controller.UserLoginMenu;

import static jdbc.bankmanage.admin.controller.AdminController.adminController;

public class UserMainMenu {
    public static void userMainMenu(){
        User user = UserLoginMenu.userLoginMenu();
        if( user==null )   return;

        //登录成功
        System.out.println("****欢迎****\n"+"用户："+user.getUser_id()+"  "+user.getUser_name());
        while (true) {
            System.out.println("您已成功以个人用户身份登录!");
            System.out.println("请选择你想要执行的操作:");
            System.out.println("\t 1.账户信息查询");
            System.out.println("\t 2.存款");
            System.out.println("\t 3.取款");
            System.out.println("\t 4.转账");
            System.out.println("\t 5.外币兑换人民币");
            System.out.println("\t 6.人民币兑换外币");
            System.out.println("\t 7.返回上一级");
            System.out.println("\t 8.退出");
            if (ControlPanel.userOperations()) break;
        }
        System.out.println("祝您生活愉快");
    }
}
