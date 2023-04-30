package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addChecks(0, x -> x instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addChecks(x -> x == null || (x instanceof Integer n && n > 0));
        return this;
    }

    public NumberSchema range(int a, int b) {
        if (a > b) {
            var c = a;
            a = b;
            b = c;
        }
        int finalA = a;
        int finalB = b;
        addChecks(x -> (int) x >= finalA && (int) x <= finalB);
        return this;
    }
}
