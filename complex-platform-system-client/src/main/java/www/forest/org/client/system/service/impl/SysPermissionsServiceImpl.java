package www.forest.org.client.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.forest.org.client.system.remote.SysPermissionsRemote;
import www.forest.org.client.system.service.SysPermissionsService;

@Service("sysPermissionsService")
public class SysPermissionsServiceImpl implements SysPermissionsService {

	@Autowired
	private SysPermissionsRemote sysPermissionsRemote;
	@Override
	public String getLevelByPermissions(Integer level, Long parentId) {
		return sysPermissionsRemote.getLevelByPermissions(level, parentId);
	}

}
