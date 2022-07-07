package jdbc.bankmanage.record.model;

public class Record {
    private String record_id;
    private String transfer_out_account;
    private String transfer_in_account;
    private String record_type;
    private double money;
    private double foreign_currency;
    private String time;

    public Record(String record_id, String transfer_out_account, String transfer_in_account, String record_type,
                  double money, double foreign_currency, String time) {
        this.record_id = record_id;
        this.transfer_out_account = transfer_out_account;
        this.transfer_in_account = transfer_in_account;
        this.record_type = record_type;
        this.money = money;
        this.foreign_currency = foreign_currency;
        this.time = time;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getTransfer_out_account() {
        return transfer_out_account;
    }

    public void setTransfer_out_account(String transfer_out_account) {
        this.transfer_out_account = transfer_out_account;
    }
    public String getTransfer_in_account() {
        return transfer_in_account;
    }

    public void setTransfer_in_account(String transfer_in_account) {
        this.transfer_in_account = transfer_in_account;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getForeign_currency() {
        return foreign_currency;
    }

    public void setForeign_currency(double foreign_currency) {
        this.foreign_currency = foreign_currency;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
