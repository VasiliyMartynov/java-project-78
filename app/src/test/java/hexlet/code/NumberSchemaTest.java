package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {

    @Test
    void stringRequiredStatusFalse() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.isValid("not number"); // true
        var expected = true;
        assertEquals(actual, expected);
    }
    @Test
    void nullRequiredStatusFalse() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void nullRequiredStatusFalseAndPositiveCheck() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        var actual = schema.positive().isValid(null); // true
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void nullStringRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(null); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void numberRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(0); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void stringRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid("5"); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void string2RequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required();
        var actual = schema.isValid("5"); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void testNumberValidator() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(10));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));

        schema.range(6, 9);
        assertFalse(schema.isValid(5));
        assertFalse(schema.isValid(10));
    }

    @Test
    void negativeRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(-5); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void zeroRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(0); // false
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void nornalNumberRequiredStatusTrue() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required().positive();
        var actual = schema.isValid(5); // true
        var expected = true;
        assertEquals(actual, expected);
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
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
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
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
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
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
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
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);

    }
}
