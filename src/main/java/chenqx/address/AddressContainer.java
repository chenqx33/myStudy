package chenqx.address;

import com.bytedance.cg.gcrm.common.util.GsonUtils;
import lombok.Data;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * @description:"address
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-12-25 11:57
 **/
@Data
public class AddressContainer {
    private Map<String, List<AddressModel>> countryToAddress;

    public static void main(String[] args) throws IOException {
        final String s = IOUtils.toString(AddressContainer.class.getClassLoader().getResource("address.json"), "UTF-8");
        final AddressContainer addressContainers = GsonUtils.fromJson(s, AddressContainer.class);
        System.out.println(addressContainers);
    }
}
