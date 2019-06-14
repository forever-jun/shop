package com.taotao.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

/**
 * Description: 
 * ClassName:FTPTest
 * @author WangXianjun
 * @date 2019年6月9日
 */

public class FTPTest {
	@Test
	public void testFtpUtil() throws Exception{
		FileInputStream inputStream = new FileInputStream(new File("F:\\1.jpg"));
		FtpUtil.uploadFile("192.168.181.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/2019/06/09", "w.jpg", inputStream);
	}
}
