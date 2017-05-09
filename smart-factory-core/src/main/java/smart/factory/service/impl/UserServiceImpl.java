package smart.factory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.domain.User;
import smart.factory.mapper.UserMapper;
import smart.factory.redis.RedisUtil;
import smart.factory.service.UserService;

import java.util.Optional;

/**
 * Created by jiadx on 17-5-2.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(userMapper);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        // 从缓存中获取城市信息
        String key = "user_" + username;
        // 缓存存在
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            Optional<User> user = (Optional<User>) redisUtil.get(key);
            return user;
        }
        // 从 DB 中获取城市信息
        Optional<User> user = userMapper.getByUsername(username);
        // 插入缓存
        redisUtil.set(key, user);

        return user;
    }
}
