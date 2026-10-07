public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){   //CONCRETE METHOD
        if (amount <= 0){
            System.out.println("Amount must be greater than zero");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful: $" + amount);
    }

    public double getBalance(){
        return balance;
    }

    public abstract void withdraw(double amount);
    public abstract void endOfMonth();
}
