package jdbc.bankmanage.foreigncurrency.model;

public class Foreigncurrency {
    private String id;
    private String account;
    private double money;
    private String exchange_rates;
    private double foreign_currency;
    private String type;

    public Foreigncurrency(String id, String account, double money,
                           String exchange_rates, double foreign_currency, String type) {
        this.id = id;
        this.account = account;
        this.money = money;
        this.exchange_rates = exchange_rates;
        this.foreign_currency = foreign_currency;
        this.type = type;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getExchange_rates() {
        return exchange_rates;
    }

    public void setExchange_rates(String exchange_rates) {
        this.exchange_rates = exchange_rates;
    }

    public double getForeign_currency() {
        return foreign_currency;
    }

    public void setForeign_currency(double foreign_currency) {
        this.foreign_currency = foreign_currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



