package chenqx.pojo;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-06 22:32
 **/
public class Parent3 {
    public String name;

    public Parent3() {
    }

    private String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Parent3)) return false;
        final Parent3 other = (Parent3) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Parent3;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "Parent3(name=" + this.getName() + ")";
    }
}
