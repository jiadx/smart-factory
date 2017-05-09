package smart.factory.mapper;

import org.springframework.stereotype.Repository;
import smart.factory.domain.User;

import java.util.Optional;

/**
 * Created by jiadx on 17-5-2.
 */
@Repository
public interface UserMapper extends BaseMapper<User>{
    Optional<User> getByUsername(String username);
}
