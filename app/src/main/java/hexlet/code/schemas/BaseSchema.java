package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> checks;

    BaseSchema() {
        this.checks = new ArrayList<>();
    }

    abstract BaseSchema required();

    public final void addChecks(Predicate p) {
        this.checks.add(p);
    }

    public final void addChecks(int index, Predicate p) {
        this.checks.add(index, p);
    }

    public final boolean isValid(Object o) {
        if (this.checks.size() == 0) {
            return true;
        }

        for (Predicate<Object> c: checks) {
            if (!c.test(o)) {
                return false;
            }
        }

        return true;
    }
}
