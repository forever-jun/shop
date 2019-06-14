package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TreeNode;

/**
 * Description: 
 * ClassName:ItemCatService
 * @author WangXianjun
 * @date 2019年6月5日
 */
public interface ItemCatService {
	
	public List<TreeNode> getItemCatList(long parentId);
}
