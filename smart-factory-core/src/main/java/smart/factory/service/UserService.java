package smart.factory.service;

import smart.factory.domain.User;

import java.util.Optional;

/**
 * Created by jiadx on 17-5-2.
 */
public interface UserService {
    Optional<User> getByUsername(String username);
}
