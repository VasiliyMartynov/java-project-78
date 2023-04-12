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
        StringSchema schema = v.string();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void nullStringRequiredStatusTrue() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void numberRequiredStatusTrue() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid(0); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

}
