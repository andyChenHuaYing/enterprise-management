package com.unjuanable.domain.orgmng.org;

/**
 * Description
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */

import com.unjuanable.application.orgmng.OrgDto;
import com.unjuanable.domain.orgmng.org.validator.OrgValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgFactory {
    private final OrgValidator validator;

    @Autowired
    public OrgFactory(OrgValidator validator) {
        this.validator = validator;
    }

    public Org build(OrgDto request) {
        validator.validate(request);
        return buildOrg(request);
    }

    private Org buildOrg(OrgDto request) {
        //DTO转换成领域对象
        return new Org();
    }
}
