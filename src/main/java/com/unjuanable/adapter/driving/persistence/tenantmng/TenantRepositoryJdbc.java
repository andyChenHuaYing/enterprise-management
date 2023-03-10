package com.unjuanable.adapter.driving.persistence.tenantmng;

import com.unjuanable.domain.tenantmng.TenantRepository;
import com.unjuanable.domain.tenantmng.TenantStatus;
import org.springframework.stereotype.Repository;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Repository
public class TenantRepositoryJdbc implements TenantRepository {
    @Override
    public boolean existsByIdAndStatus(Long tenant, TenantStatus effective) {
        return false;
    }
}
