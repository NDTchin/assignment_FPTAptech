import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountBank account = new AccountBank();

        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        account.setAccountNumber(accountNumber);

        System.out.print("Nhập tên chủ tài khoản: ");
        String accountHolderName = scanner.nextLine();
        account.setAccountHolderName(accountHolderName);

        System.out.print("Nhập số dư: ");
        double balance = scanner.nextDouble();
        account.setBalance(balance);

        System.out.println("Thông tin tài khoản ban đầu:");
        account.displayAccountInfo();
        System.out.println();

        System.out.print("Nhập số tiền muốn gửi: ");
        double depositAmount = scanner.nextDouble();
        TransactionMethod.deposit(account, depositAmount);
        System.out.println();

        System.out.print("Nhập số tiền muốn rút: ");
        double withdrawAmount = scanner.nextDouble();
        TransactionMethod.withdraw(account, withdrawAmount);
        System.out.println();

        System.out.println("---Thông tin tài khoản sau các giao dịch:---");
        account.displayAccountInfo();
    }
}