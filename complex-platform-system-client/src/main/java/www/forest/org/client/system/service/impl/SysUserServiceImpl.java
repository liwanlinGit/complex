package www.forest.org.client.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.forest.org.client.system.remote.SysUserRemote;
import www.forest.org.client.system.service.SysUserService;



@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserRemote sysUserRemote;
	
	@Override
	public String getLoginName(String loginName,String password) {
		return sysUserRemote.getLoginName(loginName, password);
	}

	@Override
	public String findLoginName(String loginName) {
		return sysUserRemote.findLoginName(loginName);
	}

}
