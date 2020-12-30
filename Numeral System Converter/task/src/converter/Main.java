package converter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String fractionalDecimalConvert(String sourceNum, int sourceRad) {
        String integer = sourceNum.split("\\.")[0];
        String fractional = sourceNum.split("\\.")[1];
        int integerDec = Integer.parseInt(integer, sourceRad);
        double fractionalDec = 0;
        for (int i = 1; i <= fractional.length(); i++) {
            double count = Integer.parseInt(String.valueOf(fractional.charAt(i - 1)), sourceRad) / Math.pow(sourceRad, i);
            fractionalDec += count;
        }
        return String.valueOf(integerDec + fractionalDec);
    }

    public static void converterInt(int sourceRad, String sourceNum, int targetRad) {
        if (sourceRad != 1 && targetRad != 1) {
            if (sourceRad == 10) {
                System.out.println(Integer.toString(Integer.parseInt(sourceNum), targetRad));
            } else {
                int num = Integer.parseInt(sourceNum, sourceRad);
                System.out.println(Integer.toString(num, targetRad));
            }
        } else if (sourceRad == 1) {
            int num = sourceNum.length();
            System.out.println(Integer.toString(num, targetRad));
        } else {
            int num = Integer.parseInt(sourceNum, sourceRad);
             System.out.println("1".repeat(Math.max(0, num)));
        }
    }

    public static void fractionalConvert(int sourceRad, String sourceNum, int targetRad) {
        String num = fractionalDecimalConvert(sourceNum, sourceRad);
        int x = Integer.parseInt(num.split("\\.")[0]);
        String numInt = Integer.toString(x, targetRad);
        StringBuilder sb = new StringBuilder();
        if (targetRad == 1) {
            for (int i = 0; i < x; i++) {
                System.out.print(1);
            }
        } else {
            sb.append(".");
            double value = Double.parseDouble("0." + num.split("\\.")[1]);
            for (int i = 0; i < 5; i++) {
                double count = value * targetRad;
                int newNum = (int) count;
                sb.append(Integer.toString(newNum, targetRad));
                value = count - newNum;
            }
            System.out.println(numInt + sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        if (scanner.hasNext("([1-9]|[1-2][0-9]|[3][0-6])")) {
            //  int inRadix = scanner.nextInt();
            int sourceRad = Integer.parseInt(scanner.nextLine());
            String sourceNum = scanner.nextLine();
            if (scanner.hasNext("([1-9]|[1-2][0-9]|[3][0-6])")) {
                int targetRad = Integer.parseInt(scanner.nextLine());
                if (sourceNum.contains(".")) {
                    fractionalConvert(sourceRad, sourceNum, targetRad);
                } else {
                    converterInt(sourceRad, sourceNum, targetRad);
                }
            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("error");
        }
    }
}