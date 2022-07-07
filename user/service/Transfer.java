package jdbc.bankmanage.user.service;

import jdbc.bankmanage.record.service.Deal_record;
import jdbc.bankmanage.util.DBUtil;
import jdbc.bankmanage.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transfer {
    private static Connection connection = DBUtil.getConnection();

    public static boolean transfer_out(User user1,User user2,String currency,double quantity){
        if (currency.equals("balance") && user1.getBalance()>=quantity){
            user1.setBalance(user1.getBalance()-quantity);
            user2.setBalance(user2.getBalance()+quantity);
            String sql = "update user set balance=(case user_id when ? then ? when ? then ? else ? end)" +
                    "where user_id in (?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user1.getUser_id());
                ps.setDouble(2, user1.getBalance());
                ps.setString(3, user2.getUser_id());
                ps.setDouble(4, user2.getBalance());
                ps.setDouble(5, user1.getBalance());
                ps.setString(6, user1.getUser_id());
                ps.setString(7, user2.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("转款成功");
                    Deal_record.transfer_record(user1,user2,currency,quantity);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (currency.equals("foreign_currency_balance") && user1.getForeign_currency_balance()>=quantity) {
            user1.setForeign_currency_balance((user1.getForeign_currency_balance() - quantity));
            user2.setForeign_currency_balance((user2.getForeign_currency_balance() + quantity));
            String sql ="update user set foreign_currency_balance=(case user_id when ? then ? when ? then ? else ? end)" +
                    "where user_id in (?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user1.getUser_id());
                ps.setDouble(2, user1.getForeign_currency_balance());
                ps.setString(3, user2.getUser_id());
                ps.setDouble(4, user2.getForeign_currency_balance());
                ps.setDouble(5, user1.getForeign_currency_balance());
                ps.setString(6, user1.getUser_id());
                ps.setString(7, user2.getUser_id());
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("转款成功");
                    Deal_record.transfer_record(user1,user2,currency,quantity);
                    System.out.println("记录成功");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("转账失败");
        return false;
    }
}
