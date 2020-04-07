package org.angzhao.demo.service.user.web;

import lombok.extern.slf4j.Slf4j;
import org.angzhao.demo.service.user.common.ResponseResult;
import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.interfaces.LoginService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.LoginParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author genvict-wuaz
 * @date 2020/4/7 19:55
 */
@RestController
@RequestMapping("/web/login")
@RefreshScope
@EnableDiscoveryClient
@Slf4j
public class LoginController  {

    @Autowired
    LoginService loginService;

    @PostMapping("login")
    @ResponseBody
    public ResponseResult<String> login(@RequestBody LoginParam param) {
        ResponseResult<String> result = new ResponseResult<>();
        String token = loginService.userLogin(param);
        if (Strings.isNotEmpty(token)) {
            result.setData(token);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }
}
