package com.unjuanable.application.orgmng;

import com.unjuanable.domain.orgmng.org.Org;
import com.unjuanable.domain.orgmng.org.OrgBuilder;
import com.unjuanable.domain.orgmng.org.OrgBuilderFactory;
import com.unjuanable.domain.orgmng.org.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Service
public class OrgService {
    private final OrgRepository orgRepository;
    private final OrgBuilderFactory orgBuilderFactory;

    @Autowired
    public OrgService(OrgRepository orgRepository, OrgBuilderFactory orgBuilderFactory) {

        this.orgRepository = orgRepository;
        this.orgBuilderFactory = orgBuilderFactory;
    }

    public OrgDto addOrg(OrgDto request, Long userId) {
        OrgBuilder builder = orgBuilderFactory.create();
        Org org = builder.tenantId(request.getTenantId())
                .orgTypeCode(request.getOrgTypeCode())
                .leaderId(request.getLeaderId())
                .superiorId(request.getSuperiorId())
                .name(request.getName())
                .createdBy(userId)
                .build();

        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private OrgDto buildOrgDto(Org org) {
        // 将领域对象的值赋给DTO...
        return null;
    }
}
