package com.unjuanable.domain.orgmng.org;

import java.util.Optional;

/**
 * 组织架构仓储
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
public interface OrgRepository {

    Optional<Org> findByIdAndStatus(long tenantId, Long id, OrgStatus status);

    int countBySuperiorAndName(long tenantId, Long superiorId, String name);

    boolean existsBySuperiorAndName(Long tenant, Long superior, String name);

    Org save(Org org);
}
