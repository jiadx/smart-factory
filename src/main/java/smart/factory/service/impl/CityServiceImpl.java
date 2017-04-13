package smart.factory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.dao.CityDao;
import smart.factory.domain.City;
import smart.factory.service.CityService;

/**
 * Created by jiadx on 17-4-13.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
