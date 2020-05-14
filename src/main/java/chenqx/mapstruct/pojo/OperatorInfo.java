package chenqx.mapstruct.pojo;

import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-13 19:01
 **/
public interface OperatorInfo {
    /**
     * 设置创建人id
     * @param createId createId
     */
    void setCreatorId(Long createId);

    /**
     * 设置creatorName
     * @param creatorName creatorName
     */
    void setCreatorName(String creatorName);

    /**
     * 设置修改人
     * @param modifyId 修改人id
     */
    void setModifyId(Long modifyId);

    /**
     * 设置修改人名称     modifyName
     * @param modifyName modifyName
     */
    void setModifyName(String modifyName);

    /**
     * 设置创建时间
     * @param createTime createTime
     */
    void setCreateTime(Date createTime);

    /**
     * 设置修改时间
     * @param modifyTime modifyTime
     */
    void setModifyTime(Date modifyTime);

}
