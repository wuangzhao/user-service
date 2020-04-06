package org.angzhao.demo.service.user.interfaces.param;

import lombok.Data;
import org.angzhao.demo.service.user.common.BaseParam;

import java.util.Date;

@Data
public class ClassParam extends BaseParam {

    private Integer classId;

    private Date time;

    private String name;
}
