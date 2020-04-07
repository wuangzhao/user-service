package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.common.Page;
import org.angzhao.demo.service.user.interfaces.dto.TeacherDTO;
import org.angzhao.demo.service.user.interfaces.param.TeacherParam;

public interface TeacherService {

    Page<TeacherDTO> queryTeacher(TeacherParam param);

    Boolean deleteTeacher(TeacherParam param);

    Boolean editTeacher(TeacherDTO teacherDTO);

    Boolean addTeacher(TeacherDTO teacherDTO);
}
