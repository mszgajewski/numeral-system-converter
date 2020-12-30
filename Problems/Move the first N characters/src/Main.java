import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int n = scn.nextInt();

        if (n > s.length()) {
            System.out.print(s);

        } else {
            System.out.print(s.substring(n));
            System.out.print(s.substring(0,n));
        }
    }
}