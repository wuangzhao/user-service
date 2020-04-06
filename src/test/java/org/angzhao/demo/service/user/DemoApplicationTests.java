package org.angzhao.demo.service.user;

import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.dal.domain.CpClassDateExample;
import org.angzhao.demo.service.user.dal.mapper.CpClassDateMapper;
import org.angzhao.demo.service.user.interfaces.ClassService;
import org.angzhao.demo.service.user.interfaces.dto.ClassDTO;
import org.angzhao.demo.service.user.interfaces.param.ClassParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    CpClassDateMapper mapper;

    @Autowired
    ClassService classService;

    @Test
    void contextLoads() {
        CpClassDateExample example = new CpClassDateExample();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Date newDate = cal1.getTime();
        cal1.add(Calendar.DATE, 1);
        cal1.add(Calendar.YEAR, 1);
        Date newDatePlus = cal1.getTime();
        example.createCriteria().andClassIdEqualTo(100000).andClassDateBetween(newDate, newDatePlus);
        CpClassDate date = new CpClassDate();
        date.setId(100000);
        date.setClassId(100000);
        date.setClassDate(new Date());
//        mapper.insert(date);
        mapper.selectByExample(example).forEach(Object::toString);
    }

    @Test
    public void fuck() {
        ClassParam param = new ClassParam();
        System.out.println(classService.queryClass(param).toString());
    }

}
