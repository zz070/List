package study;

import java.util.Scanner;

public class A {
    public void tryPractice() {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int divide(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("除 0 异常");
        }
        return x / y;
    }
}
