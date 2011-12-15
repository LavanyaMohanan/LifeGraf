package webviz.dao;

import java.util.List;

import webviz.model.Category;


public interface InterfaceDAO<T> {

	public List<T> getList();
	
}
