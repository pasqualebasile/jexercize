package it.infocube.usermanager.repository;

import it.infocube.usermanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
