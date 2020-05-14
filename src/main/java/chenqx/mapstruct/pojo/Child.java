package chenqx.mapstruct.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-13 15:30
 **/
@Data
public class Child implements TenantCodeInfo, OperatorInfo{
    /**
     * 业务无关主键
     */
    private Long id;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 基准版本号
     */
    private Integer baseVersion;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 版本状态 1-配置中；2-当前全局版本；3-历史全局版本
     */
    private Byte status;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建人name
     */
    private String creatorName;

    /**
     * 修改人id
     */
    private Long modifierId;

    /**
     * 修改人name
     */
    private String modifierName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * tenantCode
     */
    private String tenantCode;

    /**
     * 修改人id
     */
    private Long modifyId;

    /**
     * 修改人
     */
    private String modifyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getBaseVersion() {
        return baseVersion;
    }

    public void setBaseVersion(Integer baseVersion) {
        this.baseVersion = baseVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    @Override
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    @Override
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getModifyId() {
        return modifyId;
    }

    @Override
    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public String getModifyName() {
        return modifyName;
    }

    @Override
    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public enum Column {
        id("id", "id", "BIGINT"),
        sysName("sys_name", "sysName", "VARCHAR"),
        version("version", "version", "INTEGER"),
        baseVersion("base_version", "baseVersion", "INTEGER"),
        description("description", "description", "VARCHAR"),
        status("status", "status", "TINYINT"),
        creatorId("creator_id", "creatorId", "BIGINT"),
        creatorName("creator_name", "creatorName", "VARCHAR"),
        modifierId("modifier_id", "modifierId", "BIGINT"),
        modifierName("modifier_name", "modifierName", "VARCHAR"),
        createTime("create_time", "createTime", "TIMESTAMP"),
        modifyTime("modify_time", "modifyTime", "TIMESTAMP"),
        tenantCode("tenant_code", "tenantCode", "VARCHAR"),
        modifyId("modify_id", "modifyId", "BIGINT"),
        modifyName("modify_name", "modifyName", "VARCHAR");

        private final String column;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}
