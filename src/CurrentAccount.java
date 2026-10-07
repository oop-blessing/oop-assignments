public class CurrentAccount extends Account{

    private double overDraft;
    private double monthlyFee;

    public CurrentAccount(String accountNumber, double balance, double overDraft, double monthlyFee){
        super(accountNumber, balance);
        this.overDraft = overDraft;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Amount rejected; it must be positive!");
            return;
        }

        if((balance-amount) < -overDraft){
            System.out.println("Current Account withdrawal rejected: " + " overdraft limit of $" +
                    overDraft + " would exceed.");
            return;
        }

        balance -= amount;
        System.out.println("Current Amount withdrawal successful: $" + amount);
    }

    @Override
    public void endOfMonth(){
        balance -= monthlyFee;

        System.out.println("Current " + accountNumber + ": Monthly fee = $" + monthlyFee +
                ", New balance = $" + balance);
    }
}
