package com.unjuanable.application.orgmng;

import com.unjuanable.domain.orgmng.EmpRepository;
import com.unjuanable.domain.orgmng.Org;
import com.unjuanable.domain.orgmng.OrgRepository;
import com.unjuanable.domain.orgmng.OrgTypeRepository;
import com.unjuanable.domain.tenantmng.TenantRepository;
import com.unjuanable.domain.user.UserRepository;
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
    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final OrgTypeRepository orgTypeRepository;
    private final OrgRepository orgRepository;
    private final EmpRepository empRepository;

    @Autowired
    public OrgService(UserRepository userRepository
            , TenantRepository tenantRepository
            , OrgRepository orgRepository
            , EmpRepository empRepository
            , OrgTypeRepository orgTypeRepository) {

        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.orgTypeRepository = orgTypeRepository;
        this.orgRepository = orgRepository;
        this.empRepository = empRepository;
    }

    public OrgDto addOrg(OrgDto request, Long userId) {
        validate(request, userId);
        Org org = buildOrg(request, userId);
        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private OrgDto buildOrgDto(Org org) {
        // 将领域对象的值赋给DTO...
        return null;
    }

    private Org buildOrg(OrgDto request, Long useId) {
        // 将DTO的值赋给领域对象...
        return new Org();
    }

    private void validate(OrgDto request, Long userId) {
        //进行各种业务规则的校验，会用到上面的各个Repository...
    }
}
