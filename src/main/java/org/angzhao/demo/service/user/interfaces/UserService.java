package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.dto.UserDTO;
import org.angzhao.demo.service.user.interfaces.param.UserParam;

import java.util.List;

public interface UserService {

    List<ClassDTO> getUserClassById(UserParam param);
}
