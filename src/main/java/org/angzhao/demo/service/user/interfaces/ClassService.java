package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;

import java.text.ParseException;
import java.util.List;

public interface ClassService {

    ClassDTO getClassInfoByClassId(ClassParam param);

    List<ClassDTO> getClassInfoByUserIdAndDate(UserParam param) throws ParseException;

}
