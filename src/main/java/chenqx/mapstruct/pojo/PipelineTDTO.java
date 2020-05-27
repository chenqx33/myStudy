package chenqx.mapstruct.pojo;

import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-22 18:02
 **/
@Data
public class PipelineTDTO {
    public long id; // required
    public String name; // required
    public String code; // required
    public String tenantCode; // required
    public String description; // required
    public String nameI18nCode; // required
}
