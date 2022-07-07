package jdbc.bankmanage.admin.service;

import jdbc.bankmanage.user.service.*;
import jdbc.bankmanage.admin.dao.AdminDao;
import jdbc.bankmanage.admin.model.Admin;
import jdbc.bankmanage.user.model.User;
import jdbc.bankmanage.user.dao.UserDao;


import java.util.List;
import java.util.Scanner;

import static jdbc.bankmanage.user.dao.UserDao.*;

public class AdminService {

    public static Admin logIn(String id, String password){
        //根据id找对应行，再匹配密码
        Admin admin = AdminDao.selectByID(id);
        if(admin==null) return null;
        if(admin.getAdminPassword().equals(password))   return admin;
        else return null;
    }

    /*
     * 管理员的权限是：
     *   1、查询个人用户信息
     *   2、增加个人用户
     *   3、删除个人用户
     *   4、检索用户信息
     */

//调用user中service的方法来查询
    public static User selectUser(){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入要查询的用户id：");
        return AdminDao.selectByAdmin( reader.next() );
    }
    public static List<User> selectUserAll(){
        return selectAll();
    }

    public static boolean addUser(){
        Scanner reader = new Scanner(System.in);

        System.out.println("\t请输入新用户信息：");
        System.out.println("请输入编号：");
        String user_id = reader.next();

        System.out.println("请输入姓名：");
        String user_name = reader.next();

        System.out.println("请输入账户密码：");
        String user_password = reader.next();

        System.out.println("请输入账户名：");
        String account_name = reader.next();

        System.out.println("请输入开户行：");
        String account_bank = reader.next();

        System.out.println("请输入账户号：");
        String account = reader.next();

        System.out.println("请输入身份证号：");
        String id_number = reader.next();

        System.out.println("请输入用户性别：");
        String user_sex = reader.next();

        System.out.println("请输入用户年龄：");
        int user_age = reader.nextInt();

        System.out.println("请输入电话号码：");
        String phone_number = reader.next();

        System.out.println("请输入人民币余额：");
        double balance = reader.nextDouble();

        System.out.println("请输入美元余额：");
        double foreign_currency_balance = reader.nextDouble();

        User user = new User(user_id, user_name, user_password, account_name, account_bank, account, id_number,
                user_sex, user_age, phone_number, balance, foreign_currency_balance);
        return UserDao.add(user);
    }

    public static boolean deleteUser(){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入要删除的用户id：");
        String id = reader.next();
        return UserDao.delete(id);
    }

    public static boolean f_to_r_exchangeByAdmin(){
        Scanner reader = new Scanner(System.in);

        System.out.println("请输入个人用户id：");
        String userID = reader.next();
        User user = AdminDao.selectByAdmin( userID );
        if( user == null){
            System.out.println("输入id有误");
            return false;
        }

        System.out.println("请输入外币兑换金额：");
        double quantity = reader.nextDouble();

        System.out.println("请输入汇率：");
        String rate = reader.next();

        return Exchange.f_to_r_exchange(user, rate, quantity);
    }

    public static boolean r_to_f_exchangeByAdmin() {
        Scanner reader = new Scanner(System.in);

        System.out.println("请输入个人用户id：");
        String userID = reader.next();
        User userr = AdminDao.selectByAdmin(userID);
        if (userr == null) {
            System.out.println("输入id有误");
            return false;
        }

        System.out.println("请输入人民币兑换金额：");
        double quantity = reader.nextDouble();

        System.out.println("请输入汇率：");
        String rate = reader.next();

        return Exchange.r_to_f_exchange(userr, rate, quantity);
    }

}
