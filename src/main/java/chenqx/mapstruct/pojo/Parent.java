package chenqx.mapstruct.pojo;

import com.bytedance.cg.gcrm.common.validator.NotBlankExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-13 15:30
 **/
@Data
public class Parent {
    @ApiModelProperty(required = true, value = "系统名称")
    @NotBlankExt
    private String sysName;

    @ApiModelProperty(required = true, value = "需要更改的version")
    @NotBlankExt
    private Integer version;

    @ApiModelProperty(required = true, value = "需要更改描述信息")
    @NotBlankExt
    private String description;
}
