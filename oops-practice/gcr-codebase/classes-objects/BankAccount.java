class BankAccount {
    String accountNumber;
    String holder;
    double balance;
    static int totalAccounts = 0;

    BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void getStatement() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("A101", "Rahul", 5000);
        BankAccount a2 = new BankAccount("A102", "Priya", 7000);
        BankAccount a3 = new BankAccount("A103", "Amit", 6000);

        BankAccount[] accounts = {a1, a2, a3};

        for (BankAccount a : accounts) {
            a.deposit(1000);
            a.withdraw(500);
            a.deposit(2000);
            a.withdraw(3000);
            a.withdraw(7000);
            a.getStatement();
        }

        System.out.println("Total Accounts: " + BankAccount.totalAccounts);
    }
}