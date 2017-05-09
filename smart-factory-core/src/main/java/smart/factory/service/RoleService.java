package smart.factory.service;

import smart.factory.domain.Role;

import java.util.List;

/**
 * Created by jiadx on 17-5-3.
 */
public interface RoleService {
    List<Role> getByUserId(Long userId);
}
