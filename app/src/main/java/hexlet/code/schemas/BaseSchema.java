package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    boolean isValid;
    List<Predicate<Object>> checks;
    Object content;

    BaseSchema() {
        this.isValid = true;
        this.checks = new ArrayList<>();
        this.content = null;
    }

    public boolean isValid(Object o) {
        this.content = o;
        if (this.checks == null || this.checks.isEmpty()) {
            return this.isValid;
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
