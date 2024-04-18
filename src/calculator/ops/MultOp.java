package calculator.ops;

public class MultOp implements Operation {
    @Override
    public Integer compute(Integer start, Integer other) {
        return start * other;
    }
}
