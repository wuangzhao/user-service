package org.angzhao.demo.service.user.web;

import lombok.extern.slf4j.Slf4j;
import org.angzhao.demo.service.user.common.ResponseResult;
import org.angzhao.demo.service.user.interfaces.UserService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/user")
@RefreshScope
@EnableDiscoveryClient
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("userClassQuery.json")
    @ResponseBody
    public ResponseResult<List<ClassDTO>> userClassQuery(@RequestBody UserParam param) {
        ResponseResult<List<ClassDTO>> result = new ResponseResult<List<ClassDTO>>();
        List<ClassDTO> dtoList = userService.getUserClassById(param);
        result.setData(dtoList);
        return result;
    }
}
