package com.cyq.bookstore.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author Chendaben
 *
 * @param <T>
 * 分页函数
 */
public class Pager<T> {
	private int pageNo;
	private int pageSize;
	private transient int pageCount;
	private transient int fromIndex;
	private transient int toIndex;
	private int recordCount;
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Pager() {
	}

	public Pager(int pageNo, int pageSize, List<T> list) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		if (this.pageSize < 1) {
			this.pageSize = list.size();
		}
		if (this.pageSize < 1) {
			this.pageSize = 1;
		}
		this.recordCount = list.size();
		this.pageCount = recordCount / this.pageSize + (recordCount % this.pageSize > 0 ? 1 : 0);
		if (this.pageNo > pageCount) {
			this.pageNo = pageCount;
		}
		if (this.pageNo < 1) {
			this.pageNo = 1;
		}
		setFromIndex(this.pageSize * (this.pageNo - 1));
		toIndex = this.pageSize * this.pageNo;
		if (getFromIndex() >= recordCount) {
			this.list = new ArrayList<T>();
		} else if (toIndex >= recordCount) {
			this.list = list.subList(getFromIndex(), recordCount);
		} else {
			this.list = list.subList(getFromIndex(), toIndex);
		}
	}

	/**
	 * 不分页
	 * 
	 * @param list
	 */
	public Pager(List<T> list) {
		this.pageNo = 1;
		if (CollectionUtils.isNotEmpty(list)) {
			this.pageSize = list.size();
			this.recordCount = list.size();
		} else {
			this.pageSize = 0;
			this.recordCount = 0;
		}
		this.pageCount = 1;

		this.list = list;
	}

	public Pager(int pageNo, int pageSize, int recordCount) {

		this.fromIndex = pageSize * (pageNo - 1);

		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		if (recordCount > 0) {
			if (this.pageSize < 1) {
				this.pageSize = recordCount;
			}
			this.pageCount = recordCount / this.pageSize + (recordCount % this.pageSize > 0 ? 1 : 0);
		} else {
			this.pageSize = 0;
			this.pageCount = 0;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getPagerObject() {
		return list;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}

	/*public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Pager<String> page = new Pager<String>(1, 10, list); 
		JsonMapper mapper = JsonMapper.nonDefaultMapper();
		System.out.println(mapper.toJson(page.getPagerObject()));
	}*/
}
