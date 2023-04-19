package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private boolean isValid;
    private final List<Predicate<Object>> checks;
    private Object content;

    BaseSchema() {
        this.isValid = true;
        this.checks = new ArrayList<>();
        this.content = null;
    }

    public final void addChecks(Predicate p) {
        this.checks.add(p);
    }

    public final void addChecks(int index, Predicate p) {
        this.checks.add(index, p);
    }

    public final boolean isValid(Object o) {
        this.content = o;
        if (this.checks.size() == 0) {
            return true;
        } else {
            for (Predicate<Object> c: checks) {
                this.isValid = c.test(this.content);
                if (!this.isValid) {
                    return false;
                }
            }
        }
        return true;
    }
}
