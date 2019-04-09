package www.forest.org.client.system.fallback;

import org.springframework.stereotype.Component;

import www.forest.org.client.system.remote.SysPermissionsRemote;
import www.forest.org.common.util.ResultMessage;

@Component
public class SysPermissionsFallBack implements SysPermissionsRemote {

	@Override
	public String getLevelByPermissions(Integer level, Long parentId) {
		return ResultMessage.ERROR_CODE;
	}

}
