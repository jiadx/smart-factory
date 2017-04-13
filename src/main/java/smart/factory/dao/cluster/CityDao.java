package smart.factory.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import smart.factory.domain.City;

/**
 * Created by jiadx on 17-4-13.
 */
@Mapper
@Repository
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
