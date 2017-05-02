package smart.factory.service.BaseService.impl;

import smart.factory.mapper.BaseMapper;
import smart.factory.service.BaseService.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiadx on 17-4-28.
 */
public abstract class AbstractService<T extends Serializable> implements BaseService<T> {

    private BaseMapper<T> baseMapper;

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public List<T> list(T record) {
        return baseMapper.list(record);
    }

    @Override
    public int count(T record) {
        return baseMapper.count(record);
    }

    @Override
    public T getByPrimaryKey(Object key) {
        return baseMapper.getByPrimaryKey(key);
    }

    @Override
    public int save(T record) {
        return baseMapper.save(record);
    }

    @Override
    public int saveSelective(T record) {
        return baseMapper.saveSelective(record);
    }

    @Override
    public int remove(T key) {
        return baseMapper.remove(key);
    }

    @Override
    public int removeByPrimaryKey(Object key) {
        return baseMapper.removeByPrimaryKey(key);
    }

    @Override
    public int update(T record) {
        return baseMapper.update(record);
    }

    @Override
    public int updateSelective(T record) {
        return baseMapper.updateSelective(record);
    }
}
