public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBank() {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Số tài khoản : " + accountNumber);
        System.out.println("Tên chủ tài khoản : " + accountHolderName);
        System.out.println("Số dư: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}