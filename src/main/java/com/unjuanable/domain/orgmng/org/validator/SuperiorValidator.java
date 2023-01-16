package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.common.framework.BusinessException;
import com.unjuanable.common.framework.DirtyDataException;
import com.unjuanable.domain.orgmng.org.Org;
import com.unjuanable.domain.orgmng.org.OrgRepository;
import com.unjuanable.domain.orgmng.org.OrgStatus;
import com.unjuanable.domain.orgmng.orgtype.OrgType;
import com.unjuanable.domain.orgmng.orgtype.OrgTypeRepository;
import com.unjuanable.domain.orgmng.orgtype.OrgTypeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Component
public class SuperiorValidator {

    private final OrgRepository orgRepository;
    private final OrgTypeRepository orgTypeRepository;

    @Autowired
    public SuperiorValidator(OrgRepository orgRepository, OrgTypeRepository orgTypeRepository) {
        this.orgRepository = orgRepository;
        this.orgTypeRepository = orgTypeRepository;
    }

    public void verify(Long tenant, Long superiorId, String orgType) {
        // 上级组织应该是有效组织
        Org superior = orgRepository.findByIdAndStatus(tenant
                        , superiorId
                        , OrgStatus.EFFECTIVE)
                .orElseThrow(() -> new BusinessException("'" + superiorId + "' 不是有效的组织 id !"));

        // 取上级组织的组织类别
        OrgType superiorOrgType = orgTypeRepository.findByCodeAndStatus(tenant
                        , superior.getOrgTypeCode()
                        , OrgTypeStatus.EFFECTIVE)
                .orElseThrow(() ->
                        new DirtyDataException("id 为 '"
                                + superiorId
                                + "' 的组织的组织类型代码 '"
                                + superior.getOrgTypeCode() + "' 无效!"));

        // 开发组的上级只能是开发中心
        if ("DEVGRP".equals(orgType) && !"DEVCENT".equals(superiorOrgType.getCode())) {
            throw new BusinessException("开发组的上级(id = '" + superiorId + "')不是开发中心！");
        }

        // 开发中心和直属部门的上级只能是企业
        if (("DEVCENT".equals(orgType) || "DIRDEP".equals(orgType)) && !"ENTP".equals(superiorOrgType.getCode())) {
            throw new BusinessException("开发中心或直属部门的上级(id = '" + superiorId + "')不是企业！");
        }
    }
}
