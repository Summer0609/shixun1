package jdbc.bankmanage.user.service;

import jdbc.bankmanage.foreigncurrency.service.Exchange_record;
import jdbc.bankmanage.util.DBUtil;
import jdbc.bankmanage.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exchange {
    private static Connection connection = DBUtil.getConnection();

    public static boolean r_to_f_exchange(User user,String exchange_rates,double quantity){
        if(user.getBalance()>=quantity) {
            double exchange_number = quantity / Double.parseDouble(exchange_rates);
            user.setForeign_currency_balance(user.getForeign_currency_balance() + exchange_number);
            user.setBalance(user.getBalance()-quantity);
            String sql = "update user set balance=?,foreign_currency_balance=? where user_id=?";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, user.getBalance());
                ps.setDouble(2, user.getForeign_currency_balance());
                ps.setString(3, user.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("人民币兑换外币成功");
                    Exchange_record.exchange_record("balance",quantity,user,exchange_rates);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("兑换失败");
        return false;
    }

    public static boolean f_to_r_exchange(User user,String exchange_rates,double quantity){
        if(user.getForeign_currency_balance()>=quantity) {
            double exchange_number = quantity*Double.parseDouble(exchange_rates);
            user.setForeign_currency_balance(user.getForeign_currency_balance() - quantity);
            user.setBalance(user.getBalance()+exchange_number);
            String sql = "update user set balance=?,foreign_currency_balance=? where user_id=?";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, user.getBalance());
                ps.setDouble(2, user.getForeign_currency_balance());
                ps.setString(3, user.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("外币兑换人民币成功");
                    Exchange_record.exchange_record("balance",quantity,user,exchange_rates);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("兑换失败");
        return false;
    }
}
