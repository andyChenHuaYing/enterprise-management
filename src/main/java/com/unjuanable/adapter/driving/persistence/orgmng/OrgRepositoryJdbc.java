package com.unjuanable.adapter.driving.persistence.orgmng;

import com.unjuanable.domain.orgmng.org.Org;
import com.unjuanable.domain.orgmng.org.OrgRepository;
import com.unjuanable.domain.orgmng.org.OrgStatus;
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
public class OrgRepositoryJdbc implements OrgRepository {
    @Override
    public Optional<Org> findByIdAndStatus(long tenantId, Long id, OrgStatus status) {
        return Optional.empty();
    }

    @Override
    public int countBySuperiorAndName(long tenantId, Long superiorId, String name) {
        return 0;
    }

    @Override
    public boolean existsBySuperiorAndName(Long tenant, Long superior, String name) {
        return false;
    }

    @Override
    public Org save(Org org) {
        return null;
    }
}
