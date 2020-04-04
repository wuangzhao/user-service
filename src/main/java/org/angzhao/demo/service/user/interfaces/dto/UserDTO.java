package org.angzhao.demo.service.user.interfaces.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long userId;

    private String userName;

    private String password;

    private String nickName;
}
