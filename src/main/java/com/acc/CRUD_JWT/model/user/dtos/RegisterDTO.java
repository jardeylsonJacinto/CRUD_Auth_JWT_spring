package com.acc.CRUD_JWT.model.user.dtos;

import com.acc.CRUD_JWT.model.enums.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {

}
