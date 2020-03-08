package org.angzhao.demo.service.user.web;

import lombok.extern.slf4j.Slf4j;
import org.angzhao.demo.service.user.common.ResponseResult;
import org.angzhao.demo.service.user.interfaces.ClassService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/web/class")
@RefreshScope
@EnableDiscoveryClient
@Slf4j
public class ClassController {

    @Autowired
    private ClassService classService;


    @ResponseBody
    @PostMapping("classQuery.json")
    public ResponseResult<ClassDTO> getClassByClassId(@RequestBody ClassParam param) {
        ResponseResult<ClassDTO> result = new ResponseResult<>();
        ClassDTO dto = classService.getClassInfoByClassId(param);
        result.setData(dto);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @PostMapping("classDateQuery.json")
    public ResponseResult<List<ClassDTO>> getClassDateByClassId(@RequestBody UserParam param) {
        ResponseResult<List<ClassDTO>> result = new ResponseResult<>();
        try {
            result.setData(classService.getClassInfoByUserIdAndDate(param));
            result.setSuccess(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
