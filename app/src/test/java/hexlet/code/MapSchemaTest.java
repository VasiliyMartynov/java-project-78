package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
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

    @Test
    void mapShape1() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);

        var actual = schema.isValid(human1); // true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mapShape2() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        var actual = schema.isValid(human2); //true
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mapShape3() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        var actual = schema.isValid(human3); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mapShape4() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);

        var actual = schema.isValid(human4); // false
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }
}
