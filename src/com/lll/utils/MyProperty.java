package com.lll.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class MyProperty extends PropertyPlaceholderConfigurer {
   private static final Logger logger = Logger.getLogger(MyProperty.class);

  @Override
  protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
                                   Properties props) throws BeansException {
    String username = props.getProperty("username");
    String password = props.getProperty("password");
    logger.info("数据库登录"+username+"  "+password);
    super.processProperties(beanFactoryToProcess, props);
  }


}
