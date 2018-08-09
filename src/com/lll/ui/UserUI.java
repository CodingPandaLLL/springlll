package com.lll.ui;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lll.bean.User;
import com.lll.services.UserService;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserUI {

  @Resource
  private UserService userServices;

  /**
   * @time 2018年7月31日下午4:42:58
   * @author lll
   * @describe 查询
   */
  @GetMapping("/")
  public User getUser() {
    return userServices.getUser();
  }

  /**
   * @time 2018年7月31日下午4:43:50
   * @author lll
   * @describe 删除
   */
  @DeleteMapping("/{id}")
  public void delUser(@PathVariable("id") int id) {
     userServices.delUser(id);
  }

  /**
   * @time 2018年7月31日下午4:45:41
   * @author lll
   * @describe 增加
   */
  @PostMapping("/")
  public User addUser(@RequestBody User user) {
    return userServices.addUser(user);
  }
  
  /**
   *@time 2018年7月31日下午4:46:36
   *@author lll
   *@describe 修改
   */
  @PutMapping("/")
  public User updateUser(@RequestBody User user) {
    return userServices.updateUser(user);
  }
  
  
}
