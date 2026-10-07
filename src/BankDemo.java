import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("HIT001", 1000, 100,0.02));
        accounts.add(new CurrentAccount("GIT002", 500, 500,10.00));

        System.out.println("---INITIAL BALANCE---");

        for (Account account : accounts){
            System.out.println(account.accountNumber + " Balance: $" + account.getBalance());
        }

        System.out.println("\n---NORMAL TRANSACTIONS---");
        //Savings withdraw
        accounts.get(0).withdraw(200);
        //Current account withdraw
        accounts.get(1).withdraw(700);


        System.out.println("\nEDGE CASE 1: SAVINGS WITHDRAW REJECTED");
        //balance is 800 and money should not go below minimum balance, which is below $100 minimum.
        accounts.get(0).withdraw(750);

        System.out.println("\nEDGE CASE 2: CURRENT WITHDRAW REJECTED");
        // $500 is the overdraft limit.
        accounts.get(1).withdraw(400);


        System.out.println("\n---END OF MONTH---");

        //Polymorphic loop
        for (Account account : accounts){
            System.out.println("\nProcessing account: " + account.accountNumber);

            account.endOfMonth();

            System.out.println("Final balance: $" + account.getBalance());
        }
    }
}
