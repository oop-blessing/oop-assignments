public class SavingsAccount extends Account{

    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate){
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Withdrawal rejected: amount must be positive!");
            return;
        }

        if ((balance - amount) < minimumBalance){
            System.out.println("Savings withdrawal rejected: minimum balance of "
                    + minimumBalance + " must be maintained!");
            return;
        }

        balance -= amount;

        System.out.println("Savings withdrawal successful: $" + amount);
    }

    @Override
    public void endOfMonth(){
        double interest = balance * interestRate;

        balance += interest;

        System.out.println("Savings Account " + accountNumber + " Interest added = $" + interest +
                ", New balance = $" + balance);
    }
}
