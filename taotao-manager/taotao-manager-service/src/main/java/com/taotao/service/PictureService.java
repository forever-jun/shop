package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;

/**
 * Description: 
 * ClassName:PictureService
 * @author WangXianjun
 * @date 2019年6月10日
 */
public interface PictureService {
	public PictureResult uploadPicture(MultipartFile uploadFile) ;
}
