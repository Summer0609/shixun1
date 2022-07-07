package jdbc.bankmanage.admin.model;

public class Admin {
    private String adminID;
    private String adminPassword;
    private String adminName;

    public Admin(String adminName,String adminID, String adminPassword){
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String toString(){
        return "管理员ID："+getAdminID()+"\n管理员姓名："+getAdminName()+"\n管理员密码："+getAdminPassword();
    }
}
