package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {

    @Test
    void nullStatusFalse() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        var actual = schema.isValid(null); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void nullStatusTrue() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        var actual = schema.isValid(null); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void emptyHashMapStatusTrue() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        var actual = schema.isValid(new HashMap());  // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void hashMapStatusTrue() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        var actual = schema.isValid(data); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void sizeOfHashMapSize1StatusTrue() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        schema.sizeof(2);
        var actual = schema.isValid(data); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void sizeOfHashMapSize2StatusTrue() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        schema.sizeof(2);
        var actual = schema.isValid(data); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
}
