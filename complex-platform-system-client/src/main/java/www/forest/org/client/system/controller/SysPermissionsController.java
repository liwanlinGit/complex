package www.forest.org.client.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.forest.org.client.system.service.SysPermissionsService;
import www.forest.org.common.util.ResultMessage;

@RestController
@RequestMapping("/syspermissions")
public class SysPermissionsController {

	@Autowired
	private SysPermissionsService sysPermissionsService;
	
	@RequestMapping("/getUserPrmissions")
	public Map<String, Object> getUserPrmissions(Integer level,Long parentId) {
		String levelByPermissions = sysPermissionsService.getLevelByPermissions(level, parentId);
		return ResultMessage.result(levelByPermissions);
	}
	
}
