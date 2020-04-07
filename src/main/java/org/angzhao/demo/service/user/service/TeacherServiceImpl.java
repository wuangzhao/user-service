package org.angzhao.demo.service.user.service;

import com.google.common.collect.Lists;
import org.angzhao.demo.service.user.common.Page;
import org.angzhao.demo.service.user.dal.domain.CpTeacherInfo;
import org.angzhao.demo.service.user.dal.domain.CpTeacherInfoExample;
import org.angzhao.demo.service.user.dal.mapper.CpTeacherInfoMapper;
import org.angzhao.demo.service.user.interfaces.TeacherService;
import org.angzhao.demo.service.user.interfaces.dto.TeacherDTO;
import org.angzhao.demo.service.user.interfaces.param.TeacherParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * @author genvict-wuaz
 * @date 2020/4/7 19:34
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private CpTeacherInfoMapper mapper;

    @Override
    public Page<TeacherDTO> queryTeacher(TeacherParam param) {
        Page<TeacherDTO> page = new Page<>();
        int pageIndex = Math.max(param.getPageIndex() - 1, 0);
        int pageSize = Math.max(param.getPageSize(), 1);
        CpTeacherInfoExample example = new CpTeacherInfoExample();
        if (Objects.nonNull(param.getTeacherName())) {
            example.createCriteria().andTeacherNameLike("%" + param.getTeacherName() + "%");
        } else {
            example.createCriteria().andTeacherIdIsNotNull();
        }

        List<TeacherDTO> dtoList = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
        for (CpTeacherInfo info : mapper.selectByExampleWithRowbounds(example, rowBounds)) {
            TeacherDTO dto = new TeacherDTO();
            dto.setTeacherId(Long.valueOf(info.getTeacherId()));
            dto.setTeacherImgUrl(info.getTeacherImg());
            dto.setTeacherName(info.getTeacherName());
            dtoList.add(dto);
        }
        page.setResult(dtoList);
        page.setPageNo(pageIndex);
        page.setPageSize(pageSize);
        if (Objects.isNull(param.getTeacherName())) {
            example.clear();
            example.createCriteria().andTeacherIdIsNotNull();
        }
        page.setTotal(mapper.selectByExample(example).size());
        return page;
    }

    @Override
    public Boolean deleteTeacher(TeacherParam param) {
        CpTeacherInfoExample example = new CpTeacherInfoExample();
        example.createCriteria().andTeacherIdEqualTo(Integer.valueOf(param.getTeacherId()));
        return mapper.deleteByExample(example) > 0;
    }

    @Override
    public Boolean editTeacher(TeacherDTO teacherDTO) {
        CpTeacherInfoExample example = new CpTeacherInfoExample();
        example.createCriteria().andTeacherIdEqualTo(Math.toIntExact(teacherDTO.getTeacherId()));
        CpTeacherInfo info = new CpTeacherInfo();
        info.setTeacherImg(teacherDTO.getTeacherImgUrl());
        info.setTeacherId(Math.toIntExact(teacherDTO.getTeacherId()));
        info.setTeacherName(teacherDTO.getTeacherName());
        return mapper.updateByExample(info, example) > 0;
    }

    @Override
    public Boolean addTeacher(TeacherDTO teacherDTO) {
        CpTeacherInfo info = new CpTeacherInfo();
        info.setTeacherImg(teacherDTO.getTeacherImgUrl());
        info.setTeacherId(Math.toIntExact(teacherDTO.getTeacherId()));
        info.setTeacherName(teacherDTO.getTeacherName());
        return mapper.insert(info) > 0;
    }
}
