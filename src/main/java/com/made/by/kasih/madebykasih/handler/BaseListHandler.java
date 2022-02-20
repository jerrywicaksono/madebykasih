package com.made.by.kasih.madebykasih.handler;

import java.util.List;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;

public interface BaseListHandler <T extends Object>{
	public List<T> process(T object) throws ProcessBaseException;
}