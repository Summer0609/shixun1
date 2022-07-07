package jdbc.bankmanage.admin.dao;

import jdbc.bankmanage.admin.model.Admin;
import jdbc.bankmanage.util.DBUtil;
import jdbc.bankmanage.user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private static Connection connection = DBUtil.getConnection();


    public static User selectByAdmin(String id){
        String sql = "select user_id, user_name, balance, foreign_currency_balance" +
                "  from user where user_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet set = ps.executeQuery();
            // 5、遍历结果集，获取数据
            while (set.next()){
                String user_id = set.getString("user_id");
                String user_name = set.getString("user_name");
                double balance = set.getDouble("balance");
                double foreign_currency_balance = set.getDouble("foreign_currency_balance");

                User user = new User(user_id, user_name,null,null,null,null,null,
                        null, 0, null, balance, foreign_currency_balance);
                return user;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean add(Admin admin){
        String sql = "insert into admin(admin_id, admin_name, admin_password) values(?,?,?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,admin.getAdminID());
            ps.setString(2,admin.getAdminName());
            ps.setString(3,admin.getAdminPassword());

            int result  = ps.executeUpdate();
            if(result>0)    return true;

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteByID(String id){
        String sql = "delect from admin where admin_id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            int result = ps.executeUpdate();
            if(result>0)    return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateByID(Admin admin){
        String sql = "update damin set admin_name = ?, admin_password = ? where admin_id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,admin.getAdminName());
            ps.setString(2,admin.getAdminPassword());

            int result = ps.executeUpdate();
            if(result>0)    return true;

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static Admin selectByID( String id ){
        // 定义SQL语句（select语句）
        String sql = "select * from admin where admin_id=?;";
        try {
            // 2、获取预编译SQL语句的对象
            PreparedStatement ps = connection.prepareStatement(sql);
            /*
                3、设置占位符的值
                参数1：占位符在SQL语句中的索引（该索引从1开始）
             */
            ps.setString(1, id);
            // 4、执行SQL语句，并返回查询的结果集
            ResultSet set = ps.executeQuery();
            // 5、遍历结果集，获取数据
            while (set.next()){
                String admin_id = set.getString("admin_id");
                String admin_name = set.getString("admin_name");
                String admin_password = set.getString("admin_password");
                Admin admin = new Admin(admin_name, admin_id, admin_password);
                return admin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Admin> selectByName(String name ){
        // 定义SQL语句（select语句）
        String sql = "select * from admin where admin_name=? ;";
        try {
            // 2、获取预编译SQL语句的对象
            PreparedStatement ps = connection.prepareStatement(sql);
            /*
                3、设置占位符的值
                参数1：占位符在SQL语句中的索引（该索引从1开始）
             */
            ps.setString(1, name);
            List<Admin> list = new ArrayList<>();
            // 4、执行SQL语句，并返回查询的结果集
            ResultSet set = ps.executeQuery();
            // 5、遍历结果集，获取数据
            while (set.next()){
                String admin_id = set.getString("admin_id");
                String admin_name = set.getString("admin_name");
                String admin_password = set.getString("admin_password");
                Admin admin = new Admin(admin_name, admin_id, admin_password);
                list.add(admin);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
