package org.angzhao.demo.service.user.interfaces.param;

import lombok.Data;
import org.angzhao.demo.service.user.common.BaseParam;

/**
 * @author genvict-wuaz
 * @date 2020/4/7 19:32
 */
@Data
public class TeacherParam extends BaseParam {

    private String teacherName;

    private String teacherId;
}
