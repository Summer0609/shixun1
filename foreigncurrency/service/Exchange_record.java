package jdbc.bankmanage.foreigncurrency.service;

import jdbc.bankmanage.foreigncurrency.model.Foreigncurrency;
import jdbc.bankmanage.user.model.User;
import jdbc.bankmanage.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Exchange_record {
    private static Connection connection = DBUtil.getConnection();

    public static boolean f_record(Foreigncurrency foreigncurrency){
        try {
            String sql="INSERT INTO foreigncurrency ( id, account,money," +
                    "exchange_rates, foreign_currency,type) VALUE(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,foreigncurrency.getId());
            ps.setString(2,foreigncurrency.getAccount());
            ps.setDouble(3,foreigncurrency.getMoney());
            ps.setDouble(4,foreigncurrency.getForeign_currency());
            ps.setString(5,foreigncurrency.getExchange_rates());
            ps.setString(6,foreigncurrency.getType());
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean exchange_record(String currency, double quantity, User user,String exchange_rates){
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入给这次兑换赋予的编码号");
            if (currency.equals("balance")) {
                Foreigncurrency foreigncurrency=new Foreigncurrency(sc.next(), user.getAccount(),quantity,exchange_rates,
                quantity/Double.parseDouble(exchange_rates),"r_to_f");
                f_record(foreigncurrency);
            }
            if (currency.equals("foreign_currency_balance")){
                Foreigncurrency foreigncurrency=new Foreigncurrency(sc.next(), user.getAccount(),
                        quantity*Double.parseDouble(exchange_rates),exchange_rates,
                        quantity,"f_to_r");
                f_record(foreigncurrency);
            }
        return false;
    }
}
