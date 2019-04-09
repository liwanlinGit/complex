package www.forest.org.client.system.service;


public interface SysUserService {
	public String getLoginName(String loginName,String password);
	
	public String findLoginName(String loginName);
}
