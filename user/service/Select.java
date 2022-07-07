package jdbc.bankmanage.user.service;

import jdbc.bankmanage.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.bankmanage.user.model.User;
import java.util.List;

public class Select {
    // /获取连接数据库成功的Connection对象
    private static Connection connection = DBUtil.getConnection();

    //查询方法
    // 方法：查询用户所有信息
    public static List<User> selectAll() {
        List<User> list = new ArrayList<>();

        // 定义SQL语句（select语句）
        String sql = "select * from user";

        try {
            // 获取预编译SQL语句的对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 执行SQL语句，并返回查询的结果集
            ResultSet set = ps.executeQuery();
            // 遍历结果集，获取数据
            while (set.next()) {
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
                User user = new User(user_id, user_name, user_password, account_name, account_bank, account,
                        id_number, user_sex, user_age, phone_number, balance, foreign_currency_balance);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}