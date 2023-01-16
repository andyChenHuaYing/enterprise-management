package com.unjuanable.domain.orgmng.emp;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */
public interface EmpRepository {
    boolean existsByIdAndStatus(Long tenant, Long leader, EmpStatus regular, EmpStatus probation);
}
