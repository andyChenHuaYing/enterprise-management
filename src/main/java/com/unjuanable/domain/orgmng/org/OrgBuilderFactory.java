package com.unjuanable.domain.orgmng.org;

import com.unjuanable.domain.orgmng.org.validator.CommonValidator;
import com.unjuanable.domain.orgmng.org.validator.OrgLeaderValidator;
import com.unjuanable.domain.orgmng.org.validator.OrgNameValidator;
import com.unjuanable.domain.orgmng.org.validator.OrgTypeValidator;
import com.unjuanable.domain.orgmng.org.validator.SuperiorValidator;
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

public class OrgBuilderFactory {
    private final CommonValidator commonValidator;
    private final OrgTypeValidator orgTypeValidator;
    private final SuperiorValidator superiorValidator;
    private final OrgNameValidator orgNameValidator;
    private final OrgLeaderValidator orgLeaderValidator;

    @Autowired
    public OrgBuilderFactory(CommonValidator commonValidator
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

    /**
     * 每次调用都创建一个新的 OrgBuilder
     */
    public OrgBuilder create() {
        return new OrgBuilder(commonValidator, orgTypeValidator, superiorValidator, orgNameValidator, orgLeaderValidator);
    }
}