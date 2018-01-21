package com.xiang.demo.simple.core.ssl;

/**
 * 
 * <p>ClassName:KeyStoreOptions</p>
 * <p>Description: 用于存储keystore的javaBean</p>
 * <p></p>
 * @author hairui
 * @date 2017年1月9日 下午4:57:42
 */
public class KeyStoreOptions {
	
	/**
	 * 类型
	 */
	private final String type;
	/**
	 * 存储路径
	 */
	private final String path;
	/**
	 * 密码
	 */
	private final String password;
	
	/**
	 * 
	 * @param type 类型
	 * @param path 存储路径
	 * @param password 密码
	 */
	public KeyStoreOptions(String type, String path, String password) {
		super();
		this.type = type;
		this.path = path;
		this.password = password;
	}
	
	public String getType() {
		return type;
	}

	public String getPath() {
		return path;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyStoreOptions other = (KeyStoreOptions) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
