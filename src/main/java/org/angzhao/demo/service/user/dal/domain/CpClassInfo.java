package org.angzhao.demo.service.user.dal.domain;

import java.io.Serializable;

public class CpClassInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_info.class_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private Integer classId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_info.class_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_info.class_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private String classImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_class_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private Integer teacherId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cp_class_info
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_info.class_id
     *
     * @return the value of cp_class_info.class_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_info.class_id
     *
     * @param classId the value for cp_class_info.class_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_info.class_name
     *
     * @return the value of cp_class_info.class_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_info.class_name
     *
     * @param className the value for cp_class_info.class_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_info.class_img
     *
     * @return the value of cp_class_info.class_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public String getClassImg() {
        return classImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_info.class_img
     *
     * @param classImg the value for cp_class_info.class_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setClassImg(String classImg) {
        this.classImg = classImg == null ? null : classImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_class_info.teacher_id
     *
     * @return the value of cp_class_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_class_info.teacher_id
     *
     * @param teacherId the value for cp_class_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}