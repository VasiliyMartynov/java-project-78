package hexlet.code;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        this.checks.add(x -> x instanceof Integer);
        this.checks.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        this.checks.add(Objects::nonNull);
        this.checks.add(x -> (int) x > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        this.checks.add(x -> x != null);
        this.checks.add(x -> (int) x >= a);
        this.checks.add(x -> (int) x <= b);
        return this;
    }

}
