package hexlet.code.schemas;

import hexlet.code.Check;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseSchema {
    private final List<Check> checks = new ArrayList<>();

    abstract BaseSchema required();

    public final void addChecks(Check c) {
        this.checks.add(c);
    }

    public final void addChecks(int index, Check c) {
        this.checks.add(index, c);
    }

    public final boolean isValid(Object o) {
        try {
            if (!checks.stream().allMatch(c -> c.check(o))) {
                return false;
            }
        } catch (NullPointerException e) {
            return  true;
        }
        return true;
    }

}
