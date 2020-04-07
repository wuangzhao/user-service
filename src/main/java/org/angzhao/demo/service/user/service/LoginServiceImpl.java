package org.angzhao.demo.service.user.service;

import org.angzhao.demo.service.user.dal.domain.CpAdminInfo;
import org.angzhao.demo.service.user.dal.domain.CpAdminInfoExample;
import org.angzhao.demo.service.user.dal.domain.CpUserInfoExample;
import org.angzhao.demo.service.user.dal.mapper.CpAdminInfoMapper;
import org.angzhao.demo.service.user.dal.mapper.CpUserInfoMapper;
import org.angzhao.demo.service.user.interfaces.LoginService;
import org.angzhao.demo.service.user.interfaces.UserService;
import org.angzhao.demo.service.user.interfaces.param.LoginParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author genvict-wuaz
 * @date 2020/4/7 19:50
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CpUserInfoMapper userInfoMapper;

    @Autowired
    CpAdminInfoMapper adminInfoMapper;

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public String userLogin(LoginParam param) {
        CpUserInfoExample example = new CpUserInfoExample();
        if (Objects.nonNull(param.getPassword()) && Objects.nonNull(param.getUsername())) {
            example.createCriteria()
                    .andUserNameEqualTo(param.getUsername())
                    .andUserPasswordEqualTo(param.getPassword());
        } else {
            return null;
        }

        if (userInfoMapper.selectByExample(example).size() >= 1) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(param.getUsername(), token, 30, TimeUnit.MINUTES);
            return token;
        }
        return null;
    }

    @Override
    public String adminLogin(LoginParam param) {
        CpAdminInfoExample example = new CpAdminInfoExample();
        if (Objects.nonNull(param.getPassword()) && Objects.nonNull(param.getAdminName())) {
            example.createCriteria()
                    .andAdminNameEqualTo(param.getAdminName())
                    .andAdminPasswordEqualTo(param.getPassword());
        } else {
            return null;
        }
        if (adminInfoMapper.selectByExample(example).size() >= 1) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(param.getUsername(), token, 30, TimeUnit.MINUTES);
            return token;
        }
        return null;
    }

    @Override
    public Boolean register(UserParam param) {
        return userService.addUser(param);
    }
}
