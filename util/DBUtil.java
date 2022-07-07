package jdbc.bankmanage.util;

import java.sql.Connection;
import java.sql.DriverManager;

// Java连接数据库的工具类
public class DBUtil {

    // 方法：Java连接mysql数据库，并返回连接对象
    public static Connection getConnection(){
        Connection connection = null;  // 声明数据库的连接对象
        // 一、定义连接数据库的参数
        final String URL = "jdbc:mysql://localhost:3306/bankmanage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        final String DRIVER = "com.mysql.jdbc.Driver";  // 驱动类的全类名
        final String USER = "root";
        final String PASSWORD = "Paulinho020609";
        try {
            // 二、加载驱动
            Class.forName(DRIVER);
            // 三、连接数据库
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    // 方法：测试能否成功连接mysql数据库
    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
