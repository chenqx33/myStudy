```java
@Data
public class Child {
    private String name;

}
```

```java
public interface Parent {
    void setName(String name);
    void setName11(String name);
    String getName();
    String getNames();
    String hh();
}
```

```java
@Data
public class Test {
    private List<Parent> parentList;
    private String name;
}
```



```java
String json = "{\"parentList\":[{\"name\":\"1\"}],\"name\":\"22\"}"
```

1、com.alibaba.fastjson.JSON.parseObject(json, Test.class)

用fastjson序列化可以成功，即使Parent没有实现类，

他会制造一个代理对象h（是一个jsonObject）来代理Parent（就是今天出现的那个h），他会代理Parent的4个方法，他会自动解析set，get方法，比如说调用setName11("12")，name代理h这个jsonObject里面 就会增加一个键值对。

2、new GsonBuilder().create().fromJson(json,Test.class)

会报错，会提示接口没有实现类，序列化解析失败

解决方案：

​	目标对象属性中有接口的时候，需要自己造型。

```java
 private static class JsonHelper {
        private static final Gson gson;

        static {
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeHierarchyAdapter(Parent.class, new FilterDeserializer());
            gson = gsonBuilder.create();
        }

        static Test parse(String json) {
//            return JSON.parseObject(json, Test.class);
            return gson.fromJson(json,Test.class);
        }
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
                parent.setName(jsonObject.get("name").getAsString());
            }
            return parent;
        }
    }
```

总结：底层原来是写了gson解析，但是不知道什么原因，虽然自定义了解析结构但是parse里面没有用定义的gson，用了fastjson，所以导致了产生了代理对象



