package com.lll.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
	private static final Logger logger = Logger.getLogger(PropertiesUtils.class);
	private static final String FILE_NAME = "/resource/system.properties";
	private static Properties props;
	static{
		loadProps();
	}

	synchronized static private void loadProps(){
		logger.info("开始加载properties文件内容.......");
		props = new Properties();
		InputStream in = null;
		try {
			//第一种，通过类加载器进行获取properties文件流
//            in = PropertiesUtils.class.getClassLoader().getResourceAsStream(FILE_NAME);
			//第二种，通过类进行获取properties文件流
			in = PropertiesUtils.class.getResourceAsStream(FILE_NAME);
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error(FILE_NAME + "文件未找到");
		} catch (IOException e) {
			logger.error("出现IOException");
		} finally {
			try {
				if(null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error(FILE_NAME + "文件流关闭出现异常");
			}
		}
		logger.info("加载properties文件内容完成...........");
		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key){
		if(null == props) {
			loadProps();
		}
		logger.info("Get key:  "+key+"return value:"+ props.getProperty(key));
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if(null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
}
