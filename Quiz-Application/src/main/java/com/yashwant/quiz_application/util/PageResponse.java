package com.yashwant.quiz_application.util;

import java.util.List;

import lombok.Data;

@Data
public class PageResponse<T> {
	
	private List<T>content;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private int totalElements;
	private boolean lastPage;

}
