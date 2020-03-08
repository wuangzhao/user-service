package org.angzhao.demo.service.user.service;

import org.angzhao.demo.service.user.dal.domain.*;
import org.angzhao.demo.service.user.dal.mapper.CpClassDateMapper;
import org.angzhao.demo.service.user.dal.mapper.CpClassInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpTeacherInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpUserClassInfoMapper;
import org.angzhao.demo.service.user.interfaces.ClassService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private CpClassInfoMapper classInfoMapper;

    @Autowired
    private CpUserClassInfoMapper userClassInfoMapper;

    @Autowired
    private CpTeacherInfoMapper teacherInfoMapper;

    @Autowired
    private CpClassDateMapper classDateMapper;

    @Override
    public ClassDTO getClassInfoByClassId(ClassParam param) {
        CpClassInfoExample example = new CpClassInfoExample();
        example.createCriteria().andClassIdEqualTo(param.getClassId());
        List<CpClassInfo> cpClassInfos = classInfoMapper.selectByExample(example);
        if (cpClassInfos != null) {
            CpClassInfo classInfo = cpClassInfos.get(0);
            ClassDTO dto = new ClassDTO();
            CpTeacherInfoExample example1 = new CpTeacherInfoExample();
            example.createCriteria().andTeacherIdEqualTo(classInfo.getTeacherId());
            List<CpTeacherInfo> teacherInfos = teacherInfoMapper.selectByExample(example1);
            if (teacherInfos != null) {
                CpTeacherInfo teacherInfo = teacherInfos.get(0);
                dto.setTeacher(teacherInfo.getTeacherName());
            }
            dto.setClassImg(classInfo.getClassImg());
            dto.setClassName(classInfo.getClassName());
            return dto;
        }
        return null;
    }

    @Override
    public List<ClassDTO> getClassInfoByUserIdAndDate(UserParam param) {
        CpUserClassInfoExample example = new CpUserClassInfoExample();
        example.createCriteria().andUserIdEqualTo(param.getUserId());
        List<ClassDTO> classDTOS = new LinkedList<>();
        for (CpUserClassInfo userClassInfo : userClassInfoMapper.selectByExample(example)) {
            CpClassDateExample classDateExample = new CpClassDateExample();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(param.getDate());
            cal1.set(Calendar.HOUR_OF_DAY, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            cal1.set(Calendar.MILLISECOND, 0);
            Date newDate = cal1.getTime();
            cal1.add(Calendar.DATE, 1);
            Date newDatePlus = cal1.getTime();
            classDateExample.createCriteria().andClassIdEqualTo(userClassInfo.getClassId()).andClassDateBetween(newDate, newDatePlus);
            for (CpClassDate date : classDateMapper.selectByExample(classDateExample)) {
                ClassParam classParam = new ClassParam();
                classParam.setClassId(date.getClassId());
                classDTOS.add(getClassInfoByClassId(classParam));
            }
        }
        return classDTOS;
    }
}
