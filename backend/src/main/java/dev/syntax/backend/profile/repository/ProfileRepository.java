package dev.syntax.backend.profile.repository;

import dev.syntax.backend.profile.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface ProfileRepository extends CrudRepository<User, Long> {

}
