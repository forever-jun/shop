package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;

/**
 * Description: 
 * ClassName:ItemCatController
 * @author WangXianjun
 * @date 2019年6月5日
 */

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getItemCatLis(@RequestParam(value="id", defaultValue="0")Long parentId){
		List<TreeNode> itemCatList = itemCatService.getItemCatList(parentId);
		return itemCatList;
	}
	
}
