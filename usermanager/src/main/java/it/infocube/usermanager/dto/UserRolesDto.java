package it.infocube.usermanager.dto;

import it.infocube.usermanager.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * DTO per rappresentare un utente ed i suoi ruoli
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolesDto extends UserDto {
    private List<Role> roles;
}
