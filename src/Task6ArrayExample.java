public class Task6ArrayExample {

    public static void main(String[] args) {

        BankAccount[] arr = new BankAccount[3];

        arr[0] = new BankAccount("111", "Ali", 150000);
        arr[1] = new BankAccount("222", "Sara", 220000);
        arr[2] = new BankAccount("333", "Dana", 180000);

        for (BankAccount acc : arr) {
            System.out.println(acc);
        }
    }
}