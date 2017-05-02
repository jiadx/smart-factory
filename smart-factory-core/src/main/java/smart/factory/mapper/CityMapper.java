package smart.factory.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import smart.factory.domain.City;

import java.util.List;

/**
 * Created by jiadx on 17-4-13.
 */
@Repository
public interface CityMapper extends BaseMapper<City> {
}
