package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * Description: 
 * ClassName:ItemsService
 * @author WangXianjun
 * @date 2019年5月30日
 */
public interface ItemService {
	TbItem getItemById(long itemId);

	EUDataGridResult getItemList(int page, int rows);

}