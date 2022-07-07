package jdbc.bankmanage.record.service;

import jdbc.bankmanage.util.DBUtil;
import jdbc.bankmanage.record.model.Record;
import jdbc.bankmanage.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Deal_record {

    private static Connection connection = DBUtil.getConnection();

    public static boolean record(Record record){
        try {
            String sql="INSERT INTO record (record_id,transfer_out_account,transfer_in_account," +
                    "record_type, money, foreign_currency,time) VALUE(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,record.getRecord_id());
            ps.setString(2,record.getTransfer_out_account());
            ps.setString(3,record.getTransfer_in_account());
            ps.setString(4,record.getRecord_type());
            ps.setDouble(5,record.getMoney());
            ps.setDouble(6,record.getForeign_currency());
            ps.setString(7,record.getTime());
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean transfer_record(User user1, User user2, String currency, double quantity){
            Scanner sc=new Scanner(System.in);
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println("请输入给这次转账赋予的编码号");
            if (currency.equals("balance")) {
                Record record=new Record(sc.next(),user1.getAccount(),user2.getAccount(),
                        "money_transfer",quantity,0,dateFormat.format(date));
                record(record);
                }

            if (currency.equals("foreign_currency_balance")){
                Record record=new Record(sc.nextLine(),user1.getAccount(),user2.getAccount(),
                        "money_transfer",0,quantity,dateFormat.format(date));
                record(record);
            }
        return false;
    }

    public static boolean deposit_record(String currency, double quantity, User user){
            Scanner sc=new Scanner(System.in);
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println("请输入给这次存款赋予的编码号");
            if (currency.equals("balance")) {
                Record record = new Record(sc.nextLine(), user.getAccount(), user.getAccount(),
                        "money_deposit", quantity, 0, dateFormat.format(date));
                record(record);
            }
            if (currency.equals("foreign_currency_balance")){
                Record record=new Record(sc.nextLine(),user.getAccount(),user.getAccount(),
                        "money_transfer",0,quantity,dateFormat.format(date));
                record(record);
            }
        return false;
    }

    public static boolean withdraw_record(String currency, double quantity, User user){
            Scanner sc=new Scanner(System.in);
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println("请输入给这次取款赋予的编码号");
            if (currency.equals("balance")) {
                Record record = new Record(sc.nextLine(), user.getAccount(), user.getAccount(),
                        "money_deposit", quantity, 0, dateFormat.format(date));
                record(record);
            }
            if (currency.equals("foreign_currency_balance")){
                Record record=new Record(sc.nextLine(),user.getAccount(),user.getAccount(),
                        "money_transfer",0,quantity,dateFormat.format(date));
                record(record);
            }
        return false;
    }
}

