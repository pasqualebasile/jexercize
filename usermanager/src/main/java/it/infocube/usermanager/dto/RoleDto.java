package it.infocube.usermanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.infocube.usermanager.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
public class RoleDto {
    private Long id;
    private String name;
    private String description;
}
