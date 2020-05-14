package chenqx.pojo;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-06 22:31
 **/
public class Child3 extends Parent3 implements SupBook {
    private String auth;

    public Child3() {
    }

    private String getAuth() {
        return this.auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Child3)) return false;
        final Child3 other = (Child3) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$auth = this.getAuth();
        final Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Child3;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $auth = this.getAuth();
        result = result * PRIME + ($auth == null ? 43 : $auth.hashCode());
        return result;
    }

    public String toString() {
        return "Child3(auth=" + this.getAuth() + ")";
    }

    @Override
    public void tt() throws Exception {

    }
}
