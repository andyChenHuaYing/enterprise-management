package com.unjuanable.domain.orgmng.orgtype;

import java.util.Optional;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
public interface OrgTypeRepository {
    boolean existsByCodeAndStatus(Long tenant, String orgType, OrgTypeStatus effective);

    Optional<OrgType> findByCodeAndStatus(Long tenant, String orgType, OrgTypeStatus effective);
}
