import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        char[] ch = num.toCharArray();
        int counter = 1;
        int i;

        for (i = 1; i < ch.length; i++) {
                if (ch[i - 1] == ch[i] && i <= ch.length - 1) {
                    counter++;
                    continue;
                }
                System.out.print(String.valueOf(ch[i - 1]) + counter);
                counter = 1;
            }
        System.out.print(String.valueOf(ch[i - 1]) + counter);
        }
    }
