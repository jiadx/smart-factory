package smart.factory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import smart.factory.domain.City;

import java.util.List;

/**
 * Created by jiadx on 17-4-13.
 */
@Repository
public interface CityDao {
    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
