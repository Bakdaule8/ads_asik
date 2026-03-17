import java.util.Scanner;

public class Main {

    // Task 1
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // Task 2
    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }

    public static void readArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) {
            return;
        }
        arr[index] = sc.nextInt();
        readArray(arr, index + 1, sc);
    }

    // Task 3
    public static boolean isPrime(int n, int divisor) {
        if (n <= 1) {
            return false;
        }
        if (divisor == 1) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor - 1);
    }

    // Task 4
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Task 5
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Task 6
    public static long power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * power(a, n - 1);
    }

    //Task 7
    public static void reversePrintNumbers(int n, Scanner sc) {
        if (n == 0) {
            return;
        }
        int x = sc.nextInt();
        reversePrintNumbers(n - 1, sc);
        System.out.print(x + " ");
    }

    //  Task 8
    public static boolean allDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return allDigits(s, index + 1);
    }

    // Task 9
    public static int countChars(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return 1 + countChars(s.substring(1));
    }

    // Task 10
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // -------------------- Helper: Print menu recursively --------------------
    public static void printMenu() {
        System.out.println("Choose task:");
        System.out.println("1 - Print digits of a number");
        System.out.println("2 - Average of elements");
        System.out.println("3 - Prime number check");
        System.out.println("4 - Factorial");
        System.out.println("5 - Fibonacci number");
        System.out.println("6 - Power function");
        System.out.println("7 - Reverse output");
        System.out.println("8 - Check digits in string");
        System.out.println("9 - Count characters in string");
        System.out.println("10 - GCD");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printMenu();
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                // Task 1
                int n1 = sc.nextInt();
                printDigits(n1);
                break;

            case 2:
                // Task 2
                int n2 = sc.nextInt();
                int[] arr = new int[n2];
                readArray(arr, 0, sc);
                int sum = sumArray(arr, 0);
                double average = (double) sum / n2;
                System.out.println(average);
                break;

            case 3:
                // Task 3
                int n3 = sc.nextInt();
                if (isPrime(n3, n3 / 2)) {
                    System.out.println("Prime");
                } else {
                    System.out.println("Composite");
                }
                break;

            case 4:
                // Task 4
                int n4 = sc.nextInt();
                System.out.println(factorial(n4));
                break;

            case 5:
                // Task 5
                int n5 = sc.nextInt();
                System.out.println(fibonacci(n5));
                break;

            case 6:
                // Task 6
                int a = sc.nextInt();
                int n6 = sc.nextInt();
                System.out.println(power(a, n6));
                break;

            case 7:
                // Task 7
                int n7 = sc.nextInt();
                reversePrintNumbers(n7, sc);
                System.out.println();
                break;

            case 8:
                // Task 8
                String s8 = sc.next();
                if (allDigits(s8, 0)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                break;

            case 9:
                // Task 9
                String s9 = sc.next();
                System.out.println(countChars(s9));
                break;

            case 10:
                // Task 10
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(gcd(x, y));
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}