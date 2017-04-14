package smart.factory.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import smart.factory.domain.City;
import smart.factory.dubbo.CityService;

/**
 * Created by YY on 14/04/2017.
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService{
    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
