package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addChecks(x -> x instanceof String);
        addChecks(x -> x.toString().length() > 0);
        return this;
    }

    public StringSchema minLength(int n) {
        addChecks(x -> x.toString().length() >= n);
        return this;
    }

    public StringSchema contains(String s) {
        addChecks(x -> x.toString().contains(s));
        return this;
    }



}
