package com.unjuanable.adapter.driven.restful.orgmng;

import com.unjuanable.application.orgmng.OrgDto;
import com.unjuanable.application.orgmng.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 组织REST接口
 *
 * @author huaying
 * @version 0.0.1
 * @since 2023/1/16
 */

@RestController
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping("/api/organizations")
    public OrgDto addOrg(@RequestBody OrgDto request) {
        //从请求里解析出 userId ...
        Long userId = null;
        return orgService.addOrg(request, userId);
    }
}
