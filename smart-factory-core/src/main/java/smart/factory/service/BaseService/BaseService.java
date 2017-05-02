package smart.factory.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiadx on 17-4-28.
 */
public interface BaseService<T extends Serializable> {

    void setBaseMapper();

    List<T> list(T record);

    int count(T record);

    T getByPrimaryKey(Object key);

    int save(T record);

    int saveSelective(T record);

    int remove(T key);

    int removeByPrimaryKey(Object key);

    int update(T record);

    int updateSelective(T record);

}
