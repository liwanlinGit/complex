package www.forest.org.client.system.fallback;

import org.springframework.stereotype.Component;

import www.forest.org.client.system.remote.SysUserRemote;
import www.forest.org.common.util.ResultMessage;


@Component
public class SysUserFallBack implements SysUserRemote {

	@Override
	public String getLoginName(String loginName, String password) {
		return ResultMessage.ERROR_CODE;
	}

	@Override
	public String findLoginName(String loginName) {
		return ResultMessage.ERROR_CODE;
	}

}
