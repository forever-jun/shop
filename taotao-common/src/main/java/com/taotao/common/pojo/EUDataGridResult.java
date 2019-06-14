package com.taotao.common.pojo;

import java.util.List;

/**
 * Description: 
 * ClassName:EUDataGridResult
 * @author WangXianjun
 * @param <T>
 * @date 2019年6月4日
 */
public class EUDataGridResult {
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
