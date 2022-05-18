public class BankAccount {
    private String name;
    private double amount;
    private boolean isForzen;

    // Constructor Default

    BankAccount() {
        this.name = "John";
        this.amount = 2344.56;
        this.isForzen = false;
    }
    //Constructor #2
    BankAccount(String n, Double amt) {
        this.name = n;
        this.amount = amt;
        this.isForzen =false;

    }

    //getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isForzen() {
        return isForzen;
    }

    public void setForzen(boolean forzen) {
        isForzen = forzen;
    }

    // toString
    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", isForzen=" + isForzen +
                '}';
    }
}

