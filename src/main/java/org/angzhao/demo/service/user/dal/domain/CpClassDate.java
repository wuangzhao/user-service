package org.angzhao.demo.service.user.dal.domain;

import java.io.Serializable;
import java.util.Date;

public class CpClassDate implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_date.id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_date.class_id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    private Integer classId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_date.class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    private Date classDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cp_class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_date.id
     *
     * @return the value of cp_class_date.id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_date.id
     *
     * @param id the value for cp_class_date.id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_date.class_id
     *
     * @return the value of cp_class_date.class_id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_date.class_id
     *
     * @param classId the value for cp_class_date.class_id
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_date.class_date
     *
     * @return the value of cp_class_date.class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public Date getClassDate() {
        return classDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_date.class_date
     *
     * @param classDate the value for cp_class_date.class_date
     *
     * @mbg.generated Sun Mar 08 23:22:04 CST 2020
     */
    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }
}