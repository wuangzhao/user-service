package org.angzhao.demo.service.user.interfaces;

import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.angzhao.demo.service.user.interfaces.param.DateParam;

import java.util.Date;
import java.util.List;

public interface ClassDateService {

    List<CpClassDate> queryCLassDate(ClassParam param);

    Boolean deleteClassDate(DateParam param);

    Boolean addClassDate(DateParam param);
}
