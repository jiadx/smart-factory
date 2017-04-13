package smart.factory.dao.master;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import smart.factory.domain.User;

/**
 * Created by jiadx on 17-4-13.
 */
@Mapper
@Repository
public interface UserDao {
    User findByName(@Param("userName") String userName);
}
