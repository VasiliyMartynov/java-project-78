package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        this.checks.add(x -> x instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        this.checks.add(x -> {
            if (x == null) {
                return true;
            }
            return (int) x > 0;
        });
        return this;
    }

    public NumberSchema range(int a, int b) {
        if (a > b) {
            var c = a;
            a = b;
            b = c;
        }
        this.checks.add(x -> x != null);
        int finalA = (Integer) a;
        this.checks.add(x -> (int) x >= finalA);
        int finalB = (Integer) b;
        this.checks.add(x -> (int) x <= finalB);
        return this;
    }

}
