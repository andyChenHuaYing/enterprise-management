package com.unjuanable.adapter.driving.persistence.orgmng;

import com.unjuanable.domain.orgmng.emp.EmpRepository;
import com.unjuanable.domain.orgmng.emp.EmpStatus;
import org.springframework.stereotype.Repository;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
@Repository
public class EmpRepositoryJdbc implements EmpRepository {
    @Override
    public boolean existsByIdAndStatus(Long tenant, Long leader, EmpStatus regular, EmpStatus probation) {
        return false;
    }
}
