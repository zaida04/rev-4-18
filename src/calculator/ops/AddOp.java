package calculator.ops;

public class AddOp implements Operation{
    @Override
    public Integer compute(Integer start, Integer other) {
        return start + other;
    }
}
