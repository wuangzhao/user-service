package org.angzhao.demo.service.user.interfaces.param;

import lombok.Data;
import org.angzhao.demo.service.user.common.BaseParam;
import org.angzhao.demo.service.user.interfaces.dto.UserDTO;

import java.util.Date;

@Data
public class UserParam extends BaseParam {

    private Long userId;

    private Date date;

    private Date beginTime;

    private Date endTime;

    private UserDTO userInfo;

    private Integer classId;

}
