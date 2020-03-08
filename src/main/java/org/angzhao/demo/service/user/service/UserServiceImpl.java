package org.angzhao.demo.service.user.service;

import org.angzhao.demo.service.user.dal.domain.CpUserClassInfo;
import org.angzhao.demo.service.user.dal.domain.CpUserClassInfoExample;
import org.angzhao.demo.service.user.dal.mapper.CpUserClassInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpUserInfoMapper;
import org.angzhao.demo.service.user.interfaces.ClassService;
import org.angzhao.demo.service.user.interfaces.UserService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.dto.UserDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CpUserInfoMapper userInfoMapper;

    @Autowired
    private CpUserClassInfoMapper userClassInfoMapper;

    @Autowired
    private ClassService classService;

    @Override
    public List<ClassDTO> getUserClassById(UserParam param) {
        CpUserClassInfoExample example = new CpUserClassInfoExample();
        example.createCriteria().andUserIdEqualTo(param.getUserId());
        List<CpUserClassInfo> cpUserClassInfos = userClassInfoMapper.selectByExample(example);
        List<ClassDTO> classDTOS = new LinkedList<>();
        ClassParam classParam = new ClassParam();
        cpUserClassInfos.forEach(e -> {
            classParam.setClassId(e.getClassId());
            ClassDTO classDTO = classService.getClassInfoByClassId(classParam);
            if (classDTO != null){
                classDTOS.add(classDTO);
            }
        });
        return classDTOS;
    }
}
