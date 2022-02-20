package com.made.by.kasih.madebykasih.handler;

import com.made.by.kasih.madebykasih.exception.ProcessBaseException;

public interface BaseHandler <T extends Object>{
	public T process(T object) throws ProcessBaseException;
}