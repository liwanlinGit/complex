package www.forest.org.client.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.forest.org.client.system.fallback.SysPermissionsFallBack;

@FeignClient(name="complex-platform-system-service",fallback=SysPermissionsFallBack.class)
public interface SysPermissionsRemote {

	@RequestMapping("/syspermissions/getLevelByPermissions")
	public String getLevelByPermissions(@RequestParam(value = "level")Integer level,@RequestParam(value = "parentId")Long parentId);
}
