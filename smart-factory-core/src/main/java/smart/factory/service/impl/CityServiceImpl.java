package smart.factory.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.domain.City;
import smart.factory.mapper.CityMapper;
import smart.factory.redis.RedisUtil;
import smart.factory.service.BaseService.impl.AbstractService;
import smart.factory.service.CityService;

/**
 * Created by jiadx on 17-4-13.
 */
@Service
public class CityServiceImpl extends AbstractService<City> implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(cityMapper);
    }

    @Override
    public City getByPrimaryKey(Object id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        // 缓存存在
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            City city = (City) redisUtil.get(key);
            return city;
        }
        // 从 DB 中获取城市信息
        City city = cityMapper.getByPrimaryKey(id);
        // 插入缓存
        redisUtil.set(key, city);

        return city;
    }

    @Override
    public int removeByPrimaryKey(Object id) {
        int ret = cityMapper.removeByPrimaryKey(id);
        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            redisUtil.remove(key);
        }
        return ret;
    }
}
