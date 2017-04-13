package smart.factory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.factory.dao.master.UserDao;
import smart.factory.dao.cluster.CityDao;
import smart.factory.domain.City;
import smart.factory.domain.User;
import smart.factory.service.UserService;

/**
 * Created by jiadx on 17-4-13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user.setCity(city);
        return user;
    }
}
