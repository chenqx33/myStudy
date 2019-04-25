package chenqx.designpattern.factorypattern;

public class ShareFactory {
    public static <T> T getShare(Class<? extends T> clazz) {
        try {
            return (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
