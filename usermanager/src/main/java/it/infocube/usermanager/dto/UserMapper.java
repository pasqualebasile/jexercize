package it.infocube.usermanager.dto;

import it.infocube.usermanager.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setMail(user.getMail());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getMail());
        return user;
    }

    public UserRolesDto toUserRolesDto(User user) {
        UserRolesDto userRolesDto = new UserRolesDto();
        userRolesDto.setId(user.getId());
        userRolesDto.setUsername(user.getUsername());
        userRolesDto.setMail(user.getMail());
        userRolesDto.setRoles(user.getRoles());
        return userRolesDto;
    }

}
