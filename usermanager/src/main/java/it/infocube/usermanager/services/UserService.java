package it.infocube.usermanager.services;

import it.infocube.usermanager.dto.UserDto;
import it.infocube.usermanager.dto.UserMapper;
import it.infocube.usermanager.dto.UserRolesDto;
import it.infocube.usermanager.entities.User;
import it.infocube.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserDto createUser(UserDto userDto) {
        // Check if user already exists
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new DuplicateKeyException("User already exists"));
        // Map dto to entity
        User entity = userMapper.toUser(userDto);
        user = userRepository.save(entity);
        // Map entity to dto and returns it
        return userMapper.toUserDto(user);
    }

    /**
     * Get a user and all its roles from it's id
     */
    public UserRolesDto getUserRoles(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Map Entity to Dto
        UserRolesDto userRolesDto = userMapper.toUserRolesDto(user);
        return  userRolesDto;
    }

    public Iterable<UserDto> getAllUsers() {
        Iterable<UserDto> users = userRepository.findAll().stream().map(userMapper::toUserDto).toList();
        return users;
    }

    public Iterable<UserRolesDto> getAllUsersRoles() {
        return userRepository.findAll().stream().map(userMapper::toUserRolesDto).toList();
    }
}
