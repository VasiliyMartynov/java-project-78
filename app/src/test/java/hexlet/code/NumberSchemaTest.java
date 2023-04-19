package hexlet.code;


import hexlet.code.schemas.NumberSchema;
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
    void nullRequiredStatusFalse() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void nullRequiredStatusFalseAndPositiveCheck() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.positive().isValid(null); // true
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
    void string2RequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required();
        var actual = schema.isValid("5"); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNumberValidator() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        assertThat(schema.positive().isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        schema.range(6, 9);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(10)).isFalse();
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
    void nornalNumberRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(5); // true
        var expected = true;
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

    @Test
    void range2RequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        schema.range(10, 5);
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

    @Test
    void range3RequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        schema.range(5, 5);
        var actual1 = schema.isValid(5); // true
        var expected1 = true;
        var actual2 = schema.isValid(10); // false
        var expected2 = false;
        var actual3 = schema.isValid(4); // false
        var expected3 = false;
        var actual4 = schema.isValid(11); // false
        var expected4 = false;
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected4);
    }

    @Test
    void range4RequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        schema.range(6, 9);
        var actual1 = schema.isValid(5); // false
        var expected1 = false;
        var actual2 = schema.isValid(10); // false
        var expected2 = false;
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);

    }
}
