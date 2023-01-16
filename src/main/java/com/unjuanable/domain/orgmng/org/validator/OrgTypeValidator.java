package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.common.framework.BusinessException;
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
public class OrgTypeValidator {

    private final OrgTypeRepository orgTypeRepository;

    @Autowired
    public OrgTypeValidator(OrgTypeRepository orgTypeRepository) {
        this.orgTypeRepository = orgTypeRepository;
    }

    public void verify(Long tenant, String orgType) {
        // 组织类别必须有效
        if (!orgTypeRepository.existsByCodeAndStatus(tenant, orgType, OrgTypeStatus.EFFECTIVE)) {
            throw new BusinessException("'" + orgType + "'不是有效的组织类别代码！");
        }
    }
}
