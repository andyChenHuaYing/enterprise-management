package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.common.framework.BusinessException;
import com.unjuanable.domain.tenantmng.TenantRepository;
import com.unjuanable.domain.tenantmng.TenantStatus;
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
public class CommonValidator {

    private final TenantRepository tenantRepository;

    @Autowired
    public CommonValidator(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public void tenantShouldValid(Long tenant) {
        // 租户必须有效
        if (!tenantRepository.existsByIdAndStatus(tenant, TenantStatus.EFFECTIVE)) {
            throw new BusinessException("id为'" + tenant
                    + "'的租户不是有效租户！");
        }
    }
}
