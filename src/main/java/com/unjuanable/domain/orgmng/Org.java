package com.unjuanable.domain.orgmng;

import java.time.LocalDateTime;

/**
 * 组织领域实体
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */

public class Org {
    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private OrgStatus status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastUpdatedAt;
    private Long lastUpdatedBy;

    public Org() {
        //组织的初始状态默认为有效
        status = OrgStatus.EFFECTIVE;
    }

    //getters and setters ...

}
