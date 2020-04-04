package org.angzhao.demo.service.user.service;

import org.angzhao.demo.service.user.dal.domain.CpUserClassInfo;
import org.angzhao.demo.service.user.dal.domain.CpUserClassInfoExample;
import org.angzhao.demo.service.user.dal.domain.CpUserInfo;
import org.angzhao.demo.service.user.dal.domain.CpUserInfoExample;
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

    @Override
    public UserDTO addUser(UserParam param) {
        UserDTO dto = param.getUserInfo();
        CpUserInfo userInfo = new CpUserInfo();
        userInfo.setUserName(dto.getUserName());
        userInfo.setNickName(dto.getNickName());
        userInfo.setPassword(dto.getPassword());
        userInfoMapper.insert(userInfo);
        return null;
    }

    @Override
    public Boolean deleteUser(UserParam param) {
        CpUserInfoExample example = new CpUserInfoExample();
        example.createCriteria().andUserIdEqualTo(param.getUserId());
        CpUserClassInfoExample userClassInfoExample = new CpUserClassInfoExample();
        userClassInfoExample.createCriteria().andUserIdEqualTo(param.getUserId());
        userInfoMapper.deleteByExample(example);
        userClassInfoMapper.deleteByExample(userClassInfoExample);
        return true;
    }

    @Override
    public UserDTO editUser(UserParam param) {
        UserDTO dto = param.getUserInfo();
        CpUserInfoExample example = new CpUserInfoExample();
        example.createCriteria().andUserIdEqualTo(dto.getUserId());
        CpUserInfo cpUserInfo = new CpUserInfo();
        cpUserInfo.setPassword(dto.getPassword());
        cpUserInfo.setNickName(dto.getNickName());
        cpUserInfo.setUserName(dto.getUserName());
        cpUserInfo.setUserId(dto.getUserId());
        userInfoMapper.updateByExample(cpUserInfo, example);
        return dto;
    }

    @Override
    public Boolean addUserClass(UserParam param) {
        CpUserClassInfo userClassInfo = new CpUserClassInfo();
        userClassInfo.setUserId(param.getUserId());
        userClassInfo.setClassId(param.getClassId());
        userClassInfoMapper.insert(userClassInfo);
        return true;

    }

    @Override
    public Boolean deleteUserClass(UserParam param) {
        CpUserClassInfoExample example = new CpUserClassInfoExample();
        example.createCriteria().andUserIdEqualTo(param.getUserId()).andClassIdEqualTo(param.getClassId());
        userClassInfoMapper.deleteByExample(example);
        return true;
    }
}
