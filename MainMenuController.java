package jdbc.bankmanage;

import jdbc.bankmanage.admin.menu.AdminMenu;
import jdbc.bankmanage.user.menu.UserMainMenu;
import jdbc.bankmanage.util.OrderCheck;


import java.util.Scanner;

public class MainMenuController {

    public void deal(){
        MainMenu.mainMenu();
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int order= OrderCheck.checkOrder(input);
        if(order!=-1)
            switch(order){
                case 1:
                    //管理员登录
                    System.out.println("请先登录......");
                    AdminMenu.adminMenu();
                    break;
                case 2:
                    //个人用户登录
                    System.out.println("请先登录......");
                    UserMainMenu.userMainMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }

    }

}
