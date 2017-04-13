package smart.factory.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import smart.factory.domain.City;

/**
 * Created by jiadx on 17-4-13.
 */
@Repository
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
