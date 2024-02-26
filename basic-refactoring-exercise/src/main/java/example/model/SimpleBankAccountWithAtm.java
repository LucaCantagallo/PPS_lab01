package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private double fee;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double fee) {
        super(holder, balance);
        this.fee = fee;
    }

    public double getFee(){
        return this.fee;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        super.deposit(userID, substractFee(amount));
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, addFee(amount));
    }

    private double substractFee(final double amount){
        return amount-this.fee;
    }

    private double addFee(final double amount){
        return amount+this.fee;
    }
    
}
