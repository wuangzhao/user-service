package org.angzhao.demo.service.user.service;

import com.google.common.collect.Lists;
import org.angzhao.demo.service.user.common.Page;
import org.angzhao.demo.service.user.dal.domain.*;
import org.angzhao.demo.service.user.dal.mapper.CpClassDateMapper;
import org.angzhao.demo.service.user.dal.mapper.CpClassInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpTeacherInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpUserClassInfoMapper;
import org.angzhao.demo.service.user.interfaces.ClassService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            CpClassDateExample dateExample = new CpClassDateExample();
            dateExample.createCriteria().andClassDateGreaterThan(new Date()).andClassIdEqualTo(param.getClassId());
            dateExample.setOrderByClause("class_date ASC");
            List<CpClassDate> cpClassDates = classDateMapper.selectByExample(dateExample);
            if (cpClassDates != null && cpClassDates.size() > 0) {
                CpClassDate classDate = cpClassDates.get(0);
                dto.setDate(classDate.getClassDate());
                return dto;
            }
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

    @Override
    public List<Date> getClassDateByUserId(UserParam param) {
        CpUserClassInfoExample example = new CpUserClassInfoExample();
        example.createCriteria().andUserIdEqualTo(param.getUserId());
        List<Date> dates = new ArrayList<>();
        for (CpUserClassInfo userClassInfo : userClassInfoMapper.selectByExample(example)) {
            CpClassDateExample classDateExample = new CpClassDateExample();
            classDateExample.createCriteria().andClassIdEqualTo(userClassInfo.getClassId()).andClassDateBetween(param.getBeginTime(), param.getEndTime());
            for (CpClassDate date : classDateMapper.selectByExample(classDateExample)) {
                dates.add(date.getClassDate());
            }
        }
        return dates;
    }

    @Override
    public Boolean addClassInfo(CpClassInfo cpClassInfo) {
        return classInfoMapper.insert(cpClassInfo) > 0;

    }

    @Override
    public Boolean deleteClassInfo(ClassParam param) {
        CpClassDateExample classDateExample = new CpClassDateExample();
        classDateExample.createCriteria().andClassIdEqualTo(param.getClassId());
        CpUserClassInfoExample userClassInfoExample = new CpUserClassInfoExample();
        userClassInfoExample.createCriteria().andClassIdEqualTo(param.getClassId());
        CpClassInfoExample classInfoExample = new CpClassInfoExample();
        classInfoExample.createCriteria().andClassIdEqualTo(param.getClassId());

        classDateMapper.deleteByExample(classDateExample);
        userClassInfoMapper.deleteByExample(userClassInfoExample);
        return classInfoMapper.deleteByExample(classInfoExample) > 0;
    }

    @Override
    public Boolean editClassInfo(CpClassInfo cpClassInfo) {
        CpClassInfoExample example = new CpClassInfoExample();
        example.createCriteria().andClassIdEqualTo(cpClassInfo.getClassId());
        return classInfoMapper.updateByExampleSelective(cpClassInfo, example) > 0;
    }

    @Override
    public Page<ClassDTO> queryClass(ClassParam param) {
        int pageIndex = Math.max(param.getPageIndex() - 1, 0);
        int pageSize = Math.max(param.getPageSize(), 1);
        CpClassInfoExample example = new CpClassInfoExample();
        if (Objects.nonNull(param.getName())) {
            example.createCriteria().andClassNameLike("%" + param.getName() + "%");
        } else {
            example.createCriteria().andClassIdIsNotNull();
        }
        Page<ClassDTO> page = new Page<>();
        RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
        List<ClassDTO> dtos = doToDTO(classInfoMapper.selectByExampleWithRowbounds(example, rowBounds));
        page.setResult(dtos);
        page.setPageNo(pageIndex);
        page.setPageSize(pageSize);
        if (Objects.isNull(param.getName())) {
            example.clear();
            example.createCriteria().andClassIdIsNotNull();
        }
        page.setTotal(classInfoMapper.selectByExample(example).size());
        return page;
    }

    public List<ClassDTO> doToDTO(List<CpClassInfo> cpClassInfosList) {
        List<ClassDTO> dtos = Lists.newArrayList();
        System.out.println(cpClassInfosList.size());
        for (CpClassInfo classInfo : cpClassInfosList) {
            ClassDTO dto = new ClassDTO();
            dto.setClassName(classInfo.getClassName());
            dto.setClassImg(classInfo.getClassImg());
            dto.setClassId(String.valueOf(classInfo.getClassId()));
            CpTeacherInfoExample teacherInfoExample = new CpTeacherInfoExample();
            teacherInfoExample.createCriteria().andTeacherIdEqualTo(classInfo.getTeacherId());
            for (CpTeacherInfo teacherInfo : teacherInfoMapper.selectByExample(teacherInfoExample)) {
                dto.setTeacher(teacherInfo.getTeacherName());
            }
            dtos.add(dto);
        }
        return dtos;
    }


}
