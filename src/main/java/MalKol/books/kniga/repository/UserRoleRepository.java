package MalKol.books.kniga.repository;

import org.springframework.data.repository.CrudRepository;
import MalKol.books.kniga.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
