class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);
        // acc.balance = -10000; // this will never work
        acc.deposit(50);
        acc.withdraw(70);
        System.out.println(acc.getBalance());
    }

}

class BankAccount {
    private double balance; // private: nobody from the outside can access it

    BankAccount(double startingBalance) {
        if (startingBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = startingBalance; // reject invalid starting value
        }
    }

    public double getBalance() { // public getter to access curr balance
        return balance;
    }

    public void deposit(double amount) { // controlled write access, with validation
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount must be a positive number");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Amount must be positive");
        } else {
            balance -= amount;
        }
    }
}