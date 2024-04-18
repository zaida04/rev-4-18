package calculator;

import calculator.ops.AddOp;
import calculator.ops.MultOp;
import calculator.ops.NoOp;
import calculator.ops.Operation;

import java.util.ArrayList;

public class Calc {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private Integer currentNumber = 0;
    private Operation currentOperation = new NoOp();
    public String displayNumber = "0";

    public void resetNum() {
        this.currentNumber = 0;
    }

    public void clearNums() {
        this.numbers.clear();
        this.currentNumber = 0;
        this.displayNumber = "";
    }

    public void pressNum(Integer number) {
        this.currentNumber = (this.currentNumber * 10) + number;
    }

    public void pressAdd() {
        this.numbers.add(this.currentNumber);
        this.resetNum();
        this.currentOperation = new AddOp();
    }

    public void pressMult() {
        this.numbers.add(this.currentNumber);
        this.resetNum();
        this.currentOperation = new MultOp();
    }

    public void pressEquals() {
        Integer temp = this.numbers.get(0);
        this.numbers.add(this.currentNumber);
        this.resetNum();

        for(int i = 1; i < this.numbers.size(); i++) {
            temp = this.currentOperation.compute(temp, numbers.get(i));
        }

        this.displayNumber = temp.toString();
        this.numbers.clear();
        this.numbers.add(temp);
    }
}
