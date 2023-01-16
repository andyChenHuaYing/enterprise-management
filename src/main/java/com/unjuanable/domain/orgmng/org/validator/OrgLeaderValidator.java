package com.unjuanable.domain.orgmng.org.validator;

import com.unjuanable.common.framework.BusinessException;
import com.unjuanable.domain.orgmng.emp.EmpRepository;
import com.unjuanable.domain.orgmng.emp.EmpStatus;
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
public class OrgLeaderValidator {

    private final EmpRepository empRepository;

    @Autowired
    public OrgLeaderValidator(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public void verify(Long tenant, Long leader) {

        // 组织负责人可以空缺，如果有的话，的必须是一个在职员工（含试用期）
        if (leader != null
                && !empRepository.existsByIdAndStatus(tenant, leader
                , EmpStatus.REGULAR, EmpStatus.PROBATION)) {
            throw new BusinessException("组织负责人(id='" + leader + "')不是在职员工！");
        }
    }
}
