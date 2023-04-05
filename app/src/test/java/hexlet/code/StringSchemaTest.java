package hexlet.code;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {

    @Test
    void emptyStringRequiredStatusFalse() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid(""); // true
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
        schema.required();
        var actual = schema.isValid(null); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void notNullStringRequiredStatusTrue() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.isValid(""); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void numberStringRequiredStatusTrue() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.isValid(5); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void normalStringRequiredStatusTrue() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.isValid("what does the fox say"); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stringContainsString() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.contains("wh").isValid("what does the fox say"); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stringNotContainsString() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.contains("whatthe").isValid("what does the fox say"); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stringNotContainsStringAndNextIsValidCheck() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        schema.contains("whatthe").isValid("what does the fox say"); // false
        var actual = schema.isValid("what does the fox say"); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }


}
