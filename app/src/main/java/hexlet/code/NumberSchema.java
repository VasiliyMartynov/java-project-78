package hexlet.code;

public class NumberSchema extends BaseSchema {

    public void required() {
        this.checks.add(x -> x instanceof Integer);
        this.checks.add(x -> x != null);
    }

    public void positive() {
        this.checks.add(x -> (int) x > 0);
    }

    public void range(int a, int b) {
        this.checks.add(x -> (int) x > a);
        this.checks.add(x -> (int) x < b);
    }

}
