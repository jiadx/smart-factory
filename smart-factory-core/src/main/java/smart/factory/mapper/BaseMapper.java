package smart.factory.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiadx on 17-4-28.
 */
public interface BaseMapper<T extends Serializable> {

    //根据实体类不为null的字段进行查询,条件全部使用=号and条件
    List<T> list(T record);

    //根据实体类不为null的字段查询总数,条件全部使用=号and条件
    int count(T record);

    //根据主键进行查询,必须保证结果唯一
    //单个字段做主键时,可以直接写主键的值
    //联合主键时,key可以是实体类,也可以是Map
    T getByPrimaryKey(Object key);

    //插入一条数据
    //支持UUID,类似Mysql的INDENTITY自动增长(自动回写)
    //优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
    int save(T record);

    //插入一条数据,只插入不为null的字段,不会影响有默认值的字段
    //支持Mysql的INDENTITY自动增长(自动回写)
    //优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
    int saveSelective(T record);

    //根据实体类中字段不为null的条件进行删除,条件全部使用=号and条件
    int remove(T key);

    //通过主键进行删除,这里最多只会删除一条数据
    //单个字段做主键时,可以直接写主键的值
    //联合主键时,key可以是实体类,也可以是Map
    int removeByPrimaryKey(Object key);

    //根据主键进行更新,这里最多只会更新一条数据
    //参数为实体类
    int update(T record);

    //根据主键进行更新
    //只会更新不是null的数据
    int updateSelective(T record);

}