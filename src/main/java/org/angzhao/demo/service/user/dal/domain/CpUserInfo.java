package org.angzhao.demo.service.user.dal.domain;

import java.io.Serializable;

public class CpUserInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_user_info.user_id
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_user_info.user_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_user_info.user_password
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cp_user_info.nick_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cp_user_info
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_user_info.user_id
     *
     * @return the value of cp_user_info.user_id
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_user_info.user_id
     *
     * @param userId the value for cp_user_info.user_id
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_user_info.user_name
     *
     * @return the value of cp_user_info.user_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_user_info.user_name
     *
     * @param userName the value for cp_user_info.user_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_user_info.user_password
     *
     * @return the value of cp_user_info.user_password
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_user_info.user_password
     *
     * @param userPassword the value for cp_user_info.user_password
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cp_user_info.nick_name
     *
     * @return the value of cp_user_info.nick_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cp_user_info.nick_name
     *
     * @param nickName the value for cp_user_info.nick_name
     *
     * @mbg.generated Tue Apr 07 22:25:09 CST 2020
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}