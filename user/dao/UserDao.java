package jdbc.bankmanage.user.dao;

import jdbc.bankmanage.user.model.User;
import jdbc.bankmanage.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static Connection connection=DBUtil.getConnection();

    public  static boolean add(User user){//添加用户
        //定义动态SQL语句(insert 语句) ?占位符
        String sql="INSERT INTO user(user_id,user_name,user_password,account_name,account_bank,account," +
                "id_number,user_sex,user_age,phone_number,balance,foreign_currency_balance) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            //获取预编译SQL语句的对象
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUser_id());
            ps.setString(2,user.getUser_name());
            ps.setString(3,user.getUser_password());
            ps.setString(4,user.getAccount_name());
            ps.setString(5,user.getAccount_bank());
            ps.setString(6,user.getAccount());
            ps.setString(7,user.getId_number());
            ps.setString(8,user.getUser_sex());
            ps.setInt(9,user.getUser_age());
            ps.setString(10,user.getPhone_number());
            ps.setDouble(11,user.getBalance());
            ps.setDouble(12,user.getForeign_currency_balance());
            //执行SQL语句
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(String user_id){//删除用户信息
        String sql = "DELETE FROM users WHERE user_id=?";
        try{//获取预编译SQL语句对象
            PreparedStatement ps=connection.prepareStatement(sql);
            //设置占位符的值
            ps.setString(1,user_id);
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update_balance(User user){//人民币余额更改
        String sql="UPDATE users set balance=? WHERE user_id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setDouble(1,user.getBalance());
            int result=ps.executeUpdate();
            if(result>0)
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update_foreign_balance(User user){//外币余额更改
        String sql="UPDATE users set foreign_currency_balance=? WHERE user_id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setDouble(1,user.getForeign_currency_balance());
            int result=ps.executeUpdate();
            if(result>0)
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static List<User> selectAll(){//查询所有用户信息
        List<User> list=new ArrayList<>();
        String sql="SELECT * FROM user";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                String user_id = set.getString("user_id");
                String user_name = set.getString("user_name");
                String user_password = set.getString("user_password");
                String account_name = set.getString("account_name");
                String account_bank = set.getString("account_bank");
                String account = set.getString("account");
                String id_number = set.getString("id_number");
                String user_sex = set.getString("user_sex");
                int user_age = set.getInt("user_age");
                String phone_number = set.getString("phone_number");
                double balance = set.getDouble("balance");
                double foreign_currency_balance = set.getDouble("foreign_currency_balance");
                User user=new User(user_id,user_name,user_password,account_name,account_bank,
                        account,id_number,user_sex,user_age,phone_number,balance,foreign_currency_balance);
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static User selectByUser_id(String id){//更具用户id查询用户信息
        String sql="SELECT * FROM user WHERE user_id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet set=ps.executeQuery();
            while(set.next()){
                String user_id=set.getString("user_id");
                String user_name=set.getString("user_name");
                String user_password=set.getString("user_password");
                String account_name=set.getString("account_name");
                String account_bank=set.getString("account_bank");
                String account=set.getString("account");
                String id_number=set.getString("id_number");
                String user_sex=set.getString("user_sex");
                int user_age=set.getInt("user_age");
                String phone_number = set.getString("phone_number");
                double balance=set.getDouble("balance");
                double foreign_currency_balance=set.getDouble("foreign_currency_balance");
                User user=new User(user_id,user_name,user_password,account_name,account_bank,
                        account,id_number,user_sex,user_age,phone_number,balance,foreign_currency_balance);
                return user;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
