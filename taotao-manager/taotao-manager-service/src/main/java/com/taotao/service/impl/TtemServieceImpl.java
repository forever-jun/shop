package com.taotao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

/**
 * Description: 
 * ClassName:TtemServieceImpl
 * @author WangXianjun
 * @date 2019年5月30日
 */
@Service
public class TtemServieceImpl implements ItemService {

	@Resource
	TbItemMapper itemMapper;
	private Criteria createCriteria;
	@Override
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemService#getItemList(int, int)
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
				TbItemExample example = new TbItemExample();
				//分页处理
				PageHelper.startPage(page, rows);
				List<TbItem> list = itemMapper.selectByExample(example);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<TbItem> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
