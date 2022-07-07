package jdbc.bankmanage.user.service;

import jdbc.bankmanage.util.DBUtil;
import jdbc.bankmanage.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.bankmanage.record.service.Deal_record;

public class Deposit {
    private static Connection connection = DBUtil.getConnection();
    public static boolean deposit(String currency, double quantity, User user){
        if (currency.equals("balance")){
            user.setBalance(user.getBalance()+quantity);
            String sql = "update user set balance=? where user_id=?";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, user.getBalance());
                ps.setString(2, user.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("存款成功");
                    Deal_record.deposit_record(currency,quantity,user);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
        if (currency.equals("foreign_currency_balance")){
            user.setForeign_currency_balance((user.getForeign_currency_balance()+quantity));
            String sql = "update user set foreign_currency_balance=? where user_id=?";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, user.getForeign_currency_balance());
                ps.setString(2, user.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("存款成功");
                    Deal_record.deposit_record(currency,quantity,user);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("存款失败");
        return false;
    }
}
