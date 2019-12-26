package chenqx.search;

import chenqx.search.impl.Child;
import com.alibaba.fastjson.JSON;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author chenqx 2019-10-13
 * @instruction
 */
public class JsonHelper {
    private static final Gson gson;

    static {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(Parent.class, new FilterDeserializer());
        gson = gsonBuilder.create();
    }

    static TestObj parseByGson(String json) {
        return gson.fromJson(json, TestObj.class);
    }

    static TestObj parseByFastJson(String json) {
        return JSON.parseObject(json, TestObj.class);
    }


    static class FilterDeserializer implements JsonDeserializer<Parent> {

        @Override
        public Parent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (!json.isJsonObject()) {
                return null;
            }
            JsonObject jsonObject = json.getAsJsonObject();
            Parent parent = new Child();

            if (jsonObject.has("name")) {
//                parent.setName(jsonObject.get("name").getAsString());
            }
            return parent;
        }
    }
}
