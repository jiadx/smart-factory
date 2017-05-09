package smart.factory.mapper;

import org.springframework.stereotype.Repository;
import smart.factory.domain.Role;

import java.util.List;

/**
 * Created by jiadx on 17-5-2.
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getByUserId(Long userId);
}
