package chenqx.mapstruct.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-22 18:02
 **/
@Data
@AllArgsConstructor
public class PipelineDTO {
    @ApiModelProperty(required = true, value = "销售模式ID，自增主键")
    private Long idd;

    @ApiModelProperty(required = true, value = "业务ID")
    private Long pipelineId;

    @ApiModelProperty(required = true, value = "销售模式code")
    private String code;

    @ApiModelProperty(required = true, value = "销售模式名称")
    private String name;

    @ApiModelProperty(required = true, value = "销售模式名称国际化翻译Code")
    private String nameI18nCode;

    @ApiModelProperty(required = true, value = "租户code")
    private String tenantCode;

    @ApiModelProperty(required = true, value = "描述")
    private String description;
}
