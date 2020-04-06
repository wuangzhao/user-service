package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.common.Page;
import org.angzhao.demo.service.user.dal.domain.CpClassInfo;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.UserParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ClassService {

    ClassDTO getClassInfoByClassId(ClassParam param);

    List<ClassDTO> getClassInfoByUserIdAndDate(UserParam param) throws ParseException;

    List<Date> getClassDateByUserId(UserParam userParam);

    Boolean addClassInfo(CpClassInfo cpClassInfo);

    Boolean deleteClassInfo(ClassParam param);

    Boolean editClassInfo(CpClassInfo cpClassInfo);

    Page<ClassDTO> queryClass(ClassParam param);

}
