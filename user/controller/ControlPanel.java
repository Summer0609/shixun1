package jdbc.bankmanage.user.controller;

import jdbc.bankmanage.util.OrderCheck;
import jdbc.bankmanage.user.service.Deposit;
import jdbc.bankmanage.user.service.Select;
import jdbc.bankmanage.user.service.Transfer;
import jdbc.bankmanage.user.service.Withdraw;
import jdbc.bankmanage.user.service.Exchange;
import jdbc.bankmanage.user.menu.UserMainMenu;
import jdbc.bankmanage.user.dao.UserDao;
import java.util.Scanner;

public class ControlPanel {
    public static boolean userOperations() {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        int userOp= OrderCheck.checkOrder(input);
        if (userOp != -1) {
            switch (userOp) {
                case 1:
                    //查询
                    Select.selectAll();
                    break;
                case 2:
                    try {
                        System.out.println("请输入存款货币种类：");
                        String currency = sc.next();
                        System.out.println("请输入存款金额：");
                        double amount = sc.nextDouble();
                        System.out.println("请输入你要存款的账户");
                        String user_id1 = sc.next();
                        boolean b2 = Deposit.deposit(currency, amount, UserDao.selectByUser_id(user_id1));
                        if (b2) {
                            System.out.println("存款成功，当前账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id1).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id1).getForeign_currency_balance());
                        } else {
                            System.out.println("存款失败，请重新操作！");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                case 3:
                    try {
                        System.out.println("请输入货币种类：");
                        String currency = sc.next();
                        System.out.println("请输入取款金额：");
                        double amount = sc.nextDouble();
                        System.out.println("请输入你要取款的账户");
                        String user_id2 = sc.next();
                        boolean b3 = Withdraw.withdraw(currency, amount, UserDao.selectByUser_id(user_id2));
                        if (b3) {
                            System.out.println("取款成功，当前账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id2).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id2).getForeign_currency_balance());
                        } else {
                            System.out.println("取款失败，请重新操作！");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                case 4:
                    try {
                        System.out.println("请输入货币种类：");
                        String currency = sc.next();
                        System.out.println("请输入转账金额：");
                        double amount = sc.nextDouble();
                        System.out.println("请输入你要转出的账户");
                        String user_id3 = sc.next();
                        System.out.println("请输入你要转入的账户");
                        String user_id4 = sc.next();
                        boolean b4 = Transfer.transfer_out(UserDao.selectByUser_id(user_id3), UserDao.selectByUser_id(user_id4)
                                , currency, amount);
                        if (b4) {
                            System.out.println("转账成功，当前转出账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id3).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id3).getForeign_currency_balance());
                            System.out.println("转账成功，当前转入账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id4).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id4).getForeign_currency_balance());
                        } else {
                            System.out.println("转账失败，请重新操作！");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                case 5:
                    try {
                        System.out.println("请输入汇率：");
                        String exchange_rates = sc.next();
                        System.out.println("请输入兑换的数额：");
                        double amount = sc.nextDouble();
                        System.out.println("请输入你要兑换的账户");
                        String user_id5 = sc.next();
                        boolean b5 = Exchange.f_to_r_exchange(UserDao.selectByUser_id(user_id5), exchange_rates, amount);
                        if (b5) {
                            System.out.println("兑换成功，当前账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id5).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id5).getForeign_currency_balance());
                            System.out.println();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                case 6:
                    try {
                        System.out.println("请输入汇率：");
                        String exchange_rates = sc.next();
                        System.out.println("请输入兑换的数额：");
                        double amount = sc.nextDouble();
                        System.out.println("请输入你要兑换的账户");
                        String user_id6 = sc.next();
                        boolean b6 = Exchange.r_to_f_exchange(UserDao.selectByUser_id(user_id6), exchange_rates, amount);
                        if (b6) {
                            System.out.println("兑换成功，当前账户余额为：\n"
                                    + "人民币：" + UserDao.selectByUser_id(user_id6).getBalance()
                                    + "美金：" + UserDao.selectByUser_id(user_id6).getForeign_currency_balance());
                            System.out.println();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                case 7:
                    //返回上一级
                    UserMainMenu.userMainMenu();
                    return false;
                case 8:
                    sc.close();
                    System.out.println("退出成功");
                    return true;
                default:
                    System.out.println("操作有误，请重新输入！");
                    return false;
            }
        }
        return false;
    }
}
