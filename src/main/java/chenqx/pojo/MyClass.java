package chenqx.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author cqx
 * @date 2018/12/19 16:22
 */
public class MyClass {
    @SerializedName("name")
    public String a;
    @SerializedName(value = "name1", alternate = {"name2", "name3"})
    public String b;
    public String c;

    public MyClass(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
