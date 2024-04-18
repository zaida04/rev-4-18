package calculator.ops;

public class NoOp implements Operation{
    @Override
    public Integer compute(Integer start, Integer other) {
        return start;
    }
}
