package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 
 * ClassName:PageController
 * @author WangXianjun
 * @date 2019年5月31日
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String showpage(){
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page){
		return page;
	}
}
