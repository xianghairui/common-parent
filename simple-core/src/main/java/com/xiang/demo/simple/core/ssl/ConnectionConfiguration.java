package com.xiang.demo.simple.core.ssl;

/**
 * 
 * <p>ClassName:ConnectionConfiguration</p>
 * <p>Description: 证书相关信息--连接配置</p>
 * <p></p>
 * @author hairui
 * @date 2017年1月9日 下午5:12:13
 */
public class ConnectionConfiguration {

	/** 证书文件路径 */
	private String truststorePath;
	
	/** 证书类型 */
	private String truststoreType;
	
	/** 证书文件密码 */
	private String truststorePassword;
	
	/** 是否验证证书链的签名有效性 */
	private boolean verifyChainEnabled = true;
	
	/** 是否校验根证书，注意，自签名证书没有根证书 */
	private boolean verifyRootCAEnabled = true;
	
	/** 是否允许通过自签名证书 */
	private boolean selfSignedCertificateEnabled = false;
	
	/** 是否检查证书的有效期 */
	private boolean expiredCertificatesCheckEnabled = true;
	
	/** 检查域名的匹配情况 */
	private boolean notMatchingDomainCheckEnabled = true;

	private String server;
	private int port;
	
	/**
	 * 连接配置信息（使用默认值）
	 */
	public ConnectionConfiguration() {
		truststorePassword = "WlZSak5GcFVUbTlsVjJSNg==";
		truststorePath = "socket_tls_clientTrust.cert";
		truststoreType = "jks";
	}
	
	/**
	 * 连接配置
	 * @param truststorePassword 
	 * 						证书文件密码
	 * @param truststorePath 
	 * 						证书文件路径
	 * @param truststoreType 
	 * 						证书类型
	 */
	public ConnectionConfiguration(String truststorePassword, String truststorePath, String truststoreType) {
		this.truststorePassword = truststorePassword;
		this.truststorePath = truststorePath;
		this.truststoreType = truststoreType;
	}
	
	/**
	 * 连接配置
	 * @param truststorePath
	 * @param truststoreType
	 * @param truststorePassword
	 * @param verifyChainEnabled
	 * @param verifyRootCAEnabled
	 * @param selfSignedCertificateEnabled
	 * @param expiredCertificatesCheckEnabled
	 * @param notMatchingDomainCheckEnabled
	 * @param server
	 * @param port
	 */
	public ConnectionConfiguration(String truststorePath, String truststoreType, String truststorePassword,
			boolean verifyChainEnabled, boolean verifyRootCAEnabled, boolean selfSignedCertificateEnabled,
			boolean expiredCertificatesCheckEnabled, boolean notMatchingDomainCheckEnabled, String server, int port) {
		super();
		this.truststorePath = truststorePath;
		this.truststoreType = truststoreType;
		this.truststorePassword = truststorePassword;
		this.verifyChainEnabled = verifyChainEnabled;
		this.verifyRootCAEnabled = verifyRootCAEnabled;
		this.selfSignedCertificateEnabled = selfSignedCertificateEnabled;
		this.expiredCertificatesCheckEnabled = expiredCertificatesCheckEnabled;
		this.notMatchingDomainCheckEnabled = notMatchingDomainCheckEnabled;
		this.server = server;
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public boolean isExpiredCertificatesCheckEnabled() {
		return expiredCertificatesCheckEnabled;
	}

	public void setSelfSignedCertificateEnabled(boolean selfSignedCertificateEnabled) {
		this.selfSignedCertificateEnabled = selfSignedCertificateEnabled;
	}

	public void setExpiredCertificatesCheckEnabled(boolean expiredCertificatesCheckEnabled) {
		this.expiredCertificatesCheckEnabled = expiredCertificatesCheckEnabled;
	}

	public boolean isSelfSignedCertificateEnabled() {
		return selfSignedCertificateEnabled;
	}

	public boolean isNotMatchingDomainCheckEnabled() {
		return notMatchingDomainCheckEnabled;
	}

	public boolean isVerifyRootCAEnabled() {
		return verifyRootCAEnabled;
	}

	public void setVerifyRootCAEnabled(boolean verifyRootCAEnabled) {
		this.verifyRootCAEnabled = verifyRootCAEnabled;
	}

	public void setVerifyChainEnabled(boolean verifyChainEnabled) {
		this.verifyChainEnabled = verifyChainEnabled;
	}

	public boolean isVerifyChainEnabled() {

		return verifyChainEnabled;
	}

	public String getTruststoreType() {
		return truststoreType;
	}

	public void setTruststoreType(String truststoreType) {
		this.truststoreType = truststoreType;
	}

	public String getTruststorePassword() {
		return truststorePassword;
	}

	public void setTruststorePassword(String truststorePassword) {
		this.truststorePassword = truststorePassword;
	}

	public String getTruststorePath() {
		return truststorePath;
	}

	public void setTruststorePath(String truststorePath) {
		this.truststorePath = truststorePath;
	}

	public void setNotMatchingDomainCheckEnabled(boolean notMatchingDomainCheckEnabled) {
		this.notMatchingDomainCheckEnabled = notMatchingDomainCheckEnabled;
	}
}
