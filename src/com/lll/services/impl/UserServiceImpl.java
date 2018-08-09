package com.lll.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lll.bean.User;
import com.lll.dao.UserDao;
import com.lll.services.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

  @Resource
  private UserDao userDao;

  @Override
  public User getUser() {

    // User user = new User();
    // user.setEmail("lll@qw.com");
    // user.setGender("2");
    // user.setLastName("lll");

    User user = userDao.getUser().get(0);
    return user;
  }

  @Override
  public void delUser(int id) {
    userDao.delUser(id);
  }

  @Override
  public User addUser(User user) {
    userDao.addUser(user);
//    int i=1/0;
    return user;
  }

  @Override
  public User updateUser(User user) {
     userDao.updateUser(user);
     return user;
  }

}
