package org.angzhao.demo.service.user.dal.domain;

import java.io.Serializable;

public class CpTeacherInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_teacher_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private Integer teacherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_teacher_info.teacher_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private String teacherName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_teacher_info.teacher_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private String teacherImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cp_teacher_info
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_teacher_info.teacher_id
     *
     * @return the value of cp_teacher_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_teacher_info.teacher_id
     *
     * @param teacherId the value for cp_teacher_info.teacher_id
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_teacher_info.teacher_name
     *
     * @return the value of cp_teacher_info.teacher_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_teacher_info.teacher_name
     *
     * @param teacherName the value for cp_teacher_info.teacher_name
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_teacher_info.teacher_img
     *
     * @return the value of cp_teacher_info.teacher_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public String getTeacherImg() {
        return teacherImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_teacher_info.teacher_img
     *
     * @param teacherImg the value for cp_teacher_info.teacher_img
     *
     * @mbg.generated Sat Mar 07 19:12:55 CST 2020
     */
    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg == null ? null : teacherImg.trim();
    }
}