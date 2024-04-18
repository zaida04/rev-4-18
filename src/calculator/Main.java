package calculator;

import calculator.Calc;

public class Main {
    public static void main(String[] args) {
        Calc c1 = new Calc();

        // 1 + 1 = 2
        c1.pressNum(1);
        c1.pressAdd();
        c1.pressNum(1);
        c1.pressEquals();

        System.out.println(c1.displayNumber);
        c1.clearNums();

        // 1 * 5 = 5
        c1.pressNum(1);
        c1.pressMult();
        c1.pressNum(5);
        c1.pressEquals();

        System.out.println(c1.displayNumber);
        c1.clearNums();

        // 12 * 2 = 24
        c1.pressNum(1);
        c1.pressNum(2);
        c1.pressMult();
        c1.pressNum(2);
        c1.pressEquals();

        System.out.println(c1.displayNumber);
        c1.clearNums();
    }
}
