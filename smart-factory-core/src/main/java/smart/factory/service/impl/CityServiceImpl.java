package smart.factory.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.dao.CityDao;
import smart.factory.domain.City;
import smart.factory.redis.RedisUtil;
import smart.factory.service.CityService;

/**
 * Created by jiadx on 17-4-13.
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public City findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        // 缓存存在
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            City city = (City) redisUtil.get(key);
            return city;
        }
        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);
        // 插入缓存
        redisUtil.set(key, city);
        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long updateCity(City city) {
        Long ret = cityDao.updateCity(city);
        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            redisUtil.remove(key);
        }
        return ret;
    }

    @Override
    public Long deleteCity(Long id) {
        Long ret = cityDao.deleteCity(id);
        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisUtil.exists(key);
        if (hasKey) {
            redisUtil.remove(key);
        }
        return ret;
    }
}
