package org.angzhao.demo.service.user.dal.mapper;

import java.util.List;
import org.angzhao.demo.service.user.dal.domain.CpClassDate;
import org.angzhao.demo.service.user.dal.domain.CpClassDateExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CpClassDateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    long countByExample(CpClassDateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    int deleteByExample(CpClassDateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    int insert(CpClassDate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    int insertSelective(CpClassDate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    List<CpClassDate> selectByExampleWithRowbounds(CpClassDateExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    List<CpClassDate> selectByExample(CpClassDateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    int updateByExampleSelective(@Param("record") CpClassDate record, @Param("example") CpClassDateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    int updateByExample(@Param("record") CpClassDate record, @Param("example") CpClassDateExample example);
}