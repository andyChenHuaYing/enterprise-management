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

    // getters and setters ...
}
