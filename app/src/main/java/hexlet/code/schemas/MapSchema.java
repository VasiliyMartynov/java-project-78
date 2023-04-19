package hexlet.code.schemas;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addChecks(x -> x instanceof Map<?, ?>);
        return this;
    }

    public final MapSchema sizeof(int size) {
        addChecks(x -> {
            ObjectMapper mapObject = new ObjectMapper();
            HashMap map = mapObject.convertValue(x, HashMap.class);
            return map.size() >= size;
        });
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        addChecks(x -> schemas.entrySet().stream()
                .allMatch(e -> {
                    ObjectMapper mapObject = new ObjectMapper();
                    Map map = mapObject.convertValue(x, Map.class);
                    Object v = map.get(e.getKey());
                    return e.getValue().isValid(v);
                }));
        return this;
    }
}


