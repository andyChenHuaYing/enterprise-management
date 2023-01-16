package com.unjuanable.adapter.driving.persistence.orgmng;

import com.unjuanable.domain.orgmng.orgtype.OrgTypeRepository;
import com.unjuanable.domain.orgmng.orgtype.OrgTypeStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Repository
public class OrgTypeRepositoryJdbc implements OrgTypeRepository {
    @Override
    public boolean existsByCodeAndStatus(Long tenant, String orgType, OrgTypeStatus effective) {
        return false;
    }

    @Override
    public Optional findByCodeAndStatus(Long tenant, String orgType, OrgTypeStatus effective) {
        return Optional.empty();
    }
}
