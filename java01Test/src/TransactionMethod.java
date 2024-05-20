public class TransactionMethod {
    public static void deposit(AccountBank account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Bạn đã gửi tiền thành công. Số dư trong tài khoản: " + account.getBalance());
    }

    public static void withdraw(AccountBank account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Rút tiền thành công. Số dư mới trong tài khoản : " + account.getBalance());
        } else {
            System.out.println("Số dư không đủ. Rút không thành công. Vui lòng kiểm tra lại tài khoản.");
        }
    }
}
