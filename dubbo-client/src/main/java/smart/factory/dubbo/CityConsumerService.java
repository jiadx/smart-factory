package smart.factory.dubbo;

import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Reference;
import smart.factory.domain.City;

/**
 * Created by YY on 14/04/2017.
 */
@Component
public class CityConsumerService {
    @Reference(version = "1.0.0")
    CityService cityService;

    public void printCity() {
        String cityName="温岭";
        City city = cityService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
