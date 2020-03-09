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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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
        result.setTotal(1);
        result.setData(dto);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @PostMapping("classDateQuery.json")
    public ResponseResult<List<ClassDTO>> getClassDateByClassId(@RequestBody UserParam param) {
        ResponseResult<List<ClassDTO>> result = new ResponseResult<>();
        try {
            List<ClassDTO> classDTOS = classService.getClassInfoByUserIdAndDate(param);
            result.setData(classDTOS);
            result.setTotal(classDTOS.size());
            result.setSuccess(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @PostMapping("classDatesQuery.json")
    public ResponseResult<List<Date>> getClassDatesByClassId(@RequestBody UserParam param) {
        ResponseResult<List<Date>> result = new ResponseResult<>();
        try {
            List<Date> datesDto = classService.getClassDateByUserId(param);
            result.setData(datesDto);
            result.setTotal(datesDto.size());
            result.setSuccess(true);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
