package com.lll.services;

import org.springframework.transaction.annotation.Transactional;

import com.lll.bean.User;

@Transactional
public interface UserService {
  
  public User getUser();

  public void delUser(int id);

  public User addUser(User user);

  public User updateUser(User user);

}
