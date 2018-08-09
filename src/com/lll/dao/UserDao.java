package com.lll.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lll.bean.User;

@Repository("UserDao")
public interface UserDao {

  public List<User> getUser();

  public void addUser(User user);

  public void delUser(int id);

  public void updateUser(User user);
}
