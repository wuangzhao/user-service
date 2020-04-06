package org.angzhao.demo.service.user.web;

import lombok.extern.slf4j.Slf4j;
import org.angzhao.demo.service.user.common.ResponseResult;
import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.interfaces.ClassDateService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.DateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/web/date")
@RefreshScope
@EnableDiscoveryClient
@Slf4j
public class ClassDateController {

    @Autowired
    private ClassDateService classDateService;

    @ResponseBody
    @PostMapping("classDateQuery.json")
    public ResponseResult<List<CpClassDate>> getClassByClassId(@RequestBody ClassParam param) {
        ResponseResult<List<CpClassDate>> result = new ResponseResult<>();
        List<CpClassDate> cpClassDates = classDateService.queryCLassDate(param);
        result.setData(cpClassDates);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @PostMapping("deleteDate.json")
    public ResponseResult<Boolean> deleteDate(@RequestBody DateParam param) {
        ResponseResult<Boolean> result = new ResponseResult<>();
        result.setData(classDateService.deleteClassDate(param));
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @PostMapping("addDate.json")
    public ResponseResult<Boolean> addDate(@RequestBody DateParam param) {
        ResponseResult<Boolean> result = new ResponseResult<>();
        result.setData(classDateService.addClassDate(param));
        result.setSuccess(true);
        return result;
    }

}
