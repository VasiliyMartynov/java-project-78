package hexlet.code;

public final class StringSchema extends BaseSchema {

    public void required() {
        this.checks.add(x -> x instanceof String);
        this.checks.add(x -> x != null);
        this.checks.add(x -> x.toString().length() > 0);
    }

    public StringSchema minLength(int n) {
        this.checks.add(x -> x.toString().length() > n);
        return this;
    }

    public StringSchema contains(String s) {
        this.checks.add(x -> x.toString().contains(s));
        return this;
    }



}
