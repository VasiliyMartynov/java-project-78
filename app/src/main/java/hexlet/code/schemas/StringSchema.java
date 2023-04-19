package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        this.checks.clear();
        this.checks.add(x -> x instanceof String);
        this.checks.add(x -> x.toString().length() > 0);
        return this;
    }

    public StringSchema minLength(int n) {
        this.checks.add(x -> x.toString().length() >= n);
        return this;
    }

    public StringSchema contains(String s) {
        this.checks.add(x -> x.toString().contains(s));
        return this;
    }



}
