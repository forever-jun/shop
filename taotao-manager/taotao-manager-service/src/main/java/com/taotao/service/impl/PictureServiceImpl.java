package com.taotao.service.impl;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

/**
 * Description: 
 * ClassName:PictureServiceImpl
 * @author WangXianjun
 * @date 2019年6月10日
 */
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USER_NAME}")
	private String FTP_USER_NAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	
	@Override
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			PictureResult pictureResult = new PictureResult();
			pictureResult.setError(0);
			return pictureResult;
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		try {
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			PictureResult pictureResult = new PictureResult();
			pictureResult.setError(0);
			return pictureResult;
		}
		//返回结果，生成一个可以访问到图片的url返回
		String url = IMAGE_BASE_URL + filePath + "/" + imageName + ext;
		PictureResult pictureResult = new PictureResult();
		pictureResult.setUrl(url);;
		return pictureResult;
	}


}
