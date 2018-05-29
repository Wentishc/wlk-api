package ou.com.resmed.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component    
@ConfigurationProperties(prefix="commonproperty")
public class CommonBean {

	//接入基础路径
	private String wlkBaseUrl;
	
	//应用编码，第三方应用唯一标识。
	private String appid;
	
	//接入密码
	private String passwd;

	//事务编码，由物联卡集团客户按照相应规则自主生成。
	private String transid;

	//能力编码，同 appid 一起由中国移动反馈给集团客户.
	private String ebid;
	
	//令牌
	private String token;

	public String getWlkBaseUrl() {
		return wlkBaseUrl;
	}

	public void setWlkBaseUrl(String wlkBaseUrl) {
		this.wlkBaseUrl = wlkBaseUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getEbid() {
		return ebid;
	}

	public void setEbid(String ebid) {
		this.ebid = ebid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
