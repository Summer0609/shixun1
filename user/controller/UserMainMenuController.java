package jdbc.bankmanage.user.controller;

import jdbc.bankmanage.MainMenu;
import jdbc.bankmanage.user.menu.UserMainMenu;
import jdbc.bankmanage.util.OrderCheck;
import java.util.Scanner;

public class UserMainMenuController {

    public static void deal(){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int order= OrderCheck.checkOrder(input);
        if(order!=-1)
            switch(order){
                case 1:
                    //账户信息查询
                    break;
                case 2:
                    //存款
                    break;
                case 3:
                    //取款
                    break;
                case 4:
                    //转账
                    break;
                case 5:
                    //外币兑换人民币
                    break;
                case 6:
                    //人民币兑换外币
                    break;
                case 7:
                    //返回上一级
                    MainMenu.mainMenu();
                    deal();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        UserMainMenu.userMainMenu();
        ControlPanel.userOperations();
    }
}
