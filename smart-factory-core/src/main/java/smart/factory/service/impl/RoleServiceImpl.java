package smart.factory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.domain.Role;
import smart.factory.mapper.RoleMapper;
import smart.factory.service.RoleService;

import java.util.List;

/**
 * Created by jiadx on 17-5-3.
 */
@Service
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(roleMapper);
    }

    @Override
    public List<Role> getByUserId(Long userId) {
        return roleMapper.getByUserId(userId);
    }
}
