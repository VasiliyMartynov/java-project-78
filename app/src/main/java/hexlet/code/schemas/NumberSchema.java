package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addChecks(0, x -> x instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addChecks(x -> {

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
        addChecks(Objects::nonNull);
        int finalA = a;
        addChecks(x -> (int) x >= finalA);
        int finalB = b;
        addChecks(x -> (int) x <= finalB);
        return this;
    }

}
