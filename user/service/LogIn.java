package jdbc.bankmanage.user.service;

import jdbc.bankmanage.user.dao.UserDao;
import jdbc.bankmanage.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.bankmanage.user.model.User;

//登陆操作
public class LogIn {
    // /获取连接数据库成功的Connection对象
    private static Connection connection = DBUtil.getConnection();

    //登陆方法
    private static boolean logIn(String id,String password,String sql){
        try {
            //获取预编译SQL语句的对象
            PreparedStatement ps=connection.prepareStatement(sql);
            //设置占位符的值
            ps.setString(1,id);
            ps.setString(2,password);
            int result = ps.executeUpdate();  // result：表中受影响的行数
            if (result > 0) {
                System.out.println("登陆成功");
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("登陆失败");
        return  false;
    }

    //用户登陆操作
    public static User userLogIn(String user_id,String user_password) {
        User user = UserDao.selectByUser_id(user_id);
        if(user==null) return null;
        if(user.getUser_password().equals(user_password))   return user;
        else return null;
    }
}
