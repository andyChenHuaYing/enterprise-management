package com.unjuanable.application.orgmng;

import java.time.LocalDateTime;

/**
 * 组织信息数据传输对象
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */

public class OrgDto {
    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private String status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastUpdatedAt;
    private Long lastUpdatedBy;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenant(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgType(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperior(Long superiorId) {
        this.superiorId = superiorId;
    }

    public Long getLeaderId() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getters and setters ...
}
