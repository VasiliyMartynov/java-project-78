package hexlet.code;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {

    @Test
    void stringRequiredStatusFalse() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.isValid("not number"); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void nullStringRequiredStatusFalse() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void nullStringRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(null); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void numberRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(0); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stringRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid("5"); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void negativeRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(-5); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void zeroRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(0); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void rangeRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        schema.range(5, 10);
        var actual1 = schema.isValid(5); // true
        var expected1 = true;
        var actual2 = schema.isValid(10); // true
        var expected2 = true;
        var actual3 = schema.isValid(4); // false
        var expected3 = false;
        var actual4 = schema.isValid(11); // false
        var expected4 = false;
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected4);
    }

}
