package org.angzhao.demo.service.user.interfaces.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClassDTO {

    private String className;

    private String teacher;

    private String classImg;

    private String recentlyTime;

    private List<Date> dates;

    private Date date;
}
