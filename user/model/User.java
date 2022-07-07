package jdbc.bankmanage.user.model;

public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private String account_name;
    private String account_bank;
    private String account;
    private String id_number;
    private String user_sex;
    private int user_age;
    private String phone_number;
    private double balance;
    private double foreign_currency_balance;

    public User(String user_id, String user_name, String user_password, String account_name,String account_bank,
                String account,String id_number,String user_sex,int user_age,
                String phone_number,double balance,double foreign_currency_balance){
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_password=user_password;
        this.account_name=account_name;
        this.account_bank=account_bank;
        this.account=account;
        this.id_number=id_number;
        this.user_sex=user_sex;
        this.user_age=user_age;
        this.phone_number=phone_number;
        this.balance=balance;
        this.foreign_currency_balance=foreign_currency_balance;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id=user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name=user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password=user_password;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) { this.account_name=account_name; }

    public String getAccount_bank() {
        return account_bank;
    }

    public void setAccount_bank(String account_bank) {
        this.account_bank=account_bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account=account;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number (String id_number) { this.id_number=id_number; }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex=user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age=user_age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number=phone_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance=balance;
    }

    public double getForeign_currency_balance() {
        return foreign_currency_balance;
    }

    public void setForeign_currency_balance(double foreign_currency_balance) {
        this.foreign_currency_balance=foreign_currency_balance;
    }

    //查询用户信息
    @Override
    public  String toString(){
        return "用户信息:"+'\n'+
                "编号="+user_id+'\n'+
                "姓名="+user_name+'\n'+
                "账户密码="+user_password+'\n'+
                "账户名="+account_name+'\n'+
                "开户行="+account_bank+'\n'+
                "账户号="+account+'\n'+
                "身份证号"+id_number+'\n'+
                "用户性别"+user_sex+'\n'+
                "用户年龄"+user_age   +'\n'+
                "电话号码="+phone_number+'\n'+
                "人民币余额="+balance+'\n'+
                "美元余额="+foreign_currency_balance;
    }

}
