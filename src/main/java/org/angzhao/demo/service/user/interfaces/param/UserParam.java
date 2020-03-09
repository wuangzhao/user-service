package org.angzhao.demo.service.user.interfaces.param;

import lombok.Data;

import java.util.Date;

@Data
public class UserParam {

    private Long userId;

    private Date date;

    private Date beginTime;

    private Date endTime;

}
