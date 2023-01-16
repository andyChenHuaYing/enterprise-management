package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.application.orgmng.OrgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 组织校验器
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */

@Component
public class OrgValidator {
    private final CommonValidator commonValidator;
    private final OrgTypeValidator orgTypeValidator;
    private final SuperiorValidator superiorValidator;
    private final OrgNameValidator orgNameValidator;
    private final OrgLeaderValidator orgLeaderValidator;

    @Autowired
    public OrgValidator(CommonValidator commonValidator
            , OrgTypeValidator orgTypeValidator
            , SuperiorValidator superiorValidator
            , OrgNameValidator orgNameValidator
            , OrgLeaderValidator orgLeaderValidator) {
        this.commonValidator = commonValidator;
        this.superiorValidator = superiorValidator;
        this.orgTypeValidator = orgTypeValidator;
        this.orgNameValidator = orgNameValidator;
        this.orgLeaderValidator = orgLeaderValidator;
    }

    public void validate(OrgDto request) {
        final Long tenant = request.getTenantId();

        commonValidator.tenantShouldValid(tenant);
        orgLeaderValidator.verify(tenant, request.getLeaderId());
        orgTypeValidator.verify(tenant, request.getOrgTypeCode());
        superiorValidator.verify(tenant, request.getSuperiorId(), request.getName());
        orgNameValidator.verify(tenant, request.getName(), request.getSuperiorId());
    }
}
