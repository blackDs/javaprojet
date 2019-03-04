package com.c5.dao.interfaces;

import java.util.ArrayList;

public interface IDao<T> {

	void add(T t);
	void delete(T t);
	void update(T t);
	ArrayList<T> getAll();
}
