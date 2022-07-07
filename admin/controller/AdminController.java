package jdbc.bankmanage.admin.controller;

import jdbc.bankmanage.user.model.User;
import jdbc.bankmanage.admin.service.AdminService;
import java.util.List;
import java.util.Scanner;
import static jdbc.bankmanage.admin.service.AdminService.f_to_r_exchangeByAdmin;
import static jdbc.bankmanage.admin.service.AdminService.r_to_f_exchangeByAdmin;

public class AdminController {
    public static boolean adminController(){
        Scanner reader = new Scanner(System.in);

        char c = reader.next().charAt(0);
        switch (c){

            case '1':   {
                User user = AdminService.selectUser();
                if(user != null)    System.out.printf("用户id：%s\n用户姓名：%s\n人民币余额：%f\n外币余额：%f\n",
                        user.getUser_id(), user.getUser_name(), user.getBalance(),user.getForeign_currency_balance());
                else System.out.println("查询输入有误");
            }
                return false;

            case '2':
                if( AdminService.addUser() )    System.out.println("添加用户成功");
                else    System.out.println("添加用户失败");
                return false;

            case '3':
                if( AdminService.deleteUser() )    System.out.println("删除用户成功");
                else    System.out.println("删除用户失败");
                return false;

            case '4':   {
                List list = AdminService.selectUserAll();
                if( list.isEmpty() ){
                    System.out.println("数据库中没有用户");
                }
                else System.out.println(list);
            }
                return false;

            case '5':   r_to_f_exchangeByAdmin();
                return false;

            case '6':   f_to_r_exchangeByAdmin();
                return false;

            case '7':
                reader.close();
                System.out.println("退出成功");
                return true;

            default:System.out.println("输入错误，请重新选择：");
                return false;

        }
    }
}
