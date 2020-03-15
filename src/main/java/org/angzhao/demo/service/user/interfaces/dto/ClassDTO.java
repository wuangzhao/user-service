package org.angzhao.demo.service.user.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class ClassDTO {

    private String classId;

    private String className;

    private String teacher;

    private String classImg;

    private String recentlyTime;

    private List<Date> dates;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
