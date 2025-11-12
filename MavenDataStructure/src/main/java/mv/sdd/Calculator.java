package mv.sdd;

public class Calculator {
    public int add(int a, int b) { return a + b; }

    public int div(int a, int b) {
        if (b == 0) throw new ArithmeticException("division by zero");
        return a / b;
    }
}
