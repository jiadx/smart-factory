package smart.factory.service;

import smart.factory.domain.User;

/**
 * Created by jiadx on 17-4-13.
 */
public interface UserService {
    User findByName(String userName);
}
