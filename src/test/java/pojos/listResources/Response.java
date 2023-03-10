package pojos.listResources;

import java.util.List;

public class Response{
	private int perPage;
	private int total;
	private List<DataItemListResources> data;
	private int page;
	private int totalPages;
	private Support support;

	public int getPerPage(){
		return perPage;
	}

	public int getTotal(){
		return total;
	}

	public List<DataItemListResources> getData(){
		return data;
	}

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public Support getSupport(){
		return support;
	}
}