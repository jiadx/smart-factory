package smart.factory.dubbo;

import smart.factory.domain.City;

/**
 * Created by YY on 14/04/2017.
 */
public interface CityService {
    City findCityByName(String cityName);
}
