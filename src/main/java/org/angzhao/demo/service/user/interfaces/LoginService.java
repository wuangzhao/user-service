package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.interfaces.dto.UserDTO;
import org.angzhao.demo.service.user.interfaces.param.LoginParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;

public interface LoginService {

    String userLogin(LoginParam param);

    String adminLogin(LoginParam param);

    Boolean register(UserParam param);
}
