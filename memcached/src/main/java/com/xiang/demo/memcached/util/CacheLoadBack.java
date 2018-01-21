package com.xiang.demo.memcached.util;

public interface CacheLoadBack<T> {
	
	public T load();
	
}
