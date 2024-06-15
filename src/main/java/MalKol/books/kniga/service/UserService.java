package MalKol.books.kniga.service;

import MalKol.books.kniga.model.User;

import java.util.Optional;

public interface UserService {

    void registration(String username, String password);

    void deleteUserById(Long id);

    Optional<User> getUserById(Long id);
}
