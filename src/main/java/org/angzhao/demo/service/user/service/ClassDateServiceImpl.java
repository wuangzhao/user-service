package org.angzhao.demo.service.user.service;

import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.dal.domain.CpClassDateExample;
import org.angzhao.demo.service.user.dal.mapper.CpClassDateMapper;
import org.angzhao.demo.service.user.dal.mapper.CpClassInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpTeacherInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpUserClassInfoMapper;
import org.angzhao.demo.service.user.interfaces.ClassDateService;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.DateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
class ClassDateServiceImpl implements ClassDateService {

    @Autowired
    private CpClassInfoMapper classInfoMapper;

    @Autowired
    private CpUserClassInfoMapper userClassInfoMapper;

    @Autowired
    private CpTeacherInfoMapper teacherInfoMapper;

    @Autowired
    private CpClassDateMapper classDateMapper;

    @Override
    public List<CpClassDate> queryCLassDate(ClassParam param) {
        CpClassDateExample example = new CpClassDateExample();
        example.createCriteria().andClassIdEqualTo(param.getClassId());
        return classDateMapper.selectByExample(example);
    }

    @Override
    public Boolean deleteClassDate(DateParam param) {
        CpClassDateExample example = new CpClassDateExample();
        example.createCriteria().andIdEqualTo(Integer.valueOf(param.getDataId()));
        return classDateMapper.deleteByExample(example) > 0;
    }

    @Override
    public Boolean addClassDate(DateParam param) {
        CpClassDate classDate = new CpClassDate();
        classDate.setClassDate(param.getTime());
        classDate.setClassId(Integer.valueOf(param.getClassId()));
        return classDateMapper.insert(classDate) > 0;
    }
}
