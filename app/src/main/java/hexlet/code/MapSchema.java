package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    public void required() {
        this.checks.add(x -> x instanceof Map<?, ?>);
        this.checks.add(Objects::nonNull);
    }

    public void sizeof(int size) {
        this.checks.add(x -> {
            ObjectMapper mapObject = new ObjectMapper();
            HashMap<String, String> map = mapObject.convertValue(x, HashMap.class);
            return map.size() >= size;
        });
    }
}
