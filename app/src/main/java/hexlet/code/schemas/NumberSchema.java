package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        this.checks.add(0, x -> x instanceof Integer);
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
        this.checks.add(Objects::nonNull);
        int finalA = a;
        this.checks.add(x -> (int) x >= finalA);
        int finalB = b;
        this.checks.add(x -> (int) x <= finalB);
        return this;
    }

}
