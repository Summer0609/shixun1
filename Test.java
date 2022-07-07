package jdbc.bankmanage;

import jdbc.bankmanage.util.DBUtil;

public class Test {
    public static void main(String[] args){
        DBUtil.getConnection();
        MainMenuController test1=new MainMenuController();
        test1.deal();
    }
}
