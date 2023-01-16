package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.common.framework.BusinessException;
import com.unjuanable.domain.orgmng.org.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.util.Strings.isBlank;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Component
public class OrgNameValidator {
    private final OrgRepository orgRepository;

    @Autowired
    public OrgNameValidator(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public void verify(Long tenant, String name, Long superior) {

        // 组织必须有名称
        if (isBlank(name)) {
            throw new BusinessException("组织没有名称！");
        }

        // 同一个组织下的下级组织不能重名
        if (orgRepository.existsBySuperiorAndName(tenant, superior, name)) {
            throw new BusinessException("同一上级下已经有名为'" + name + "'的组织存在！");
        }
    }
}
