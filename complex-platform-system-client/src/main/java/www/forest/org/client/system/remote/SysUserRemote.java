package www.forest.org.client.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.forest.org.client.system.fallback.SysUserFallBack;

@FeignClient(name="complex-platform-system-service",fallback=SysUserFallBack.class)
public interface SysUserRemote {
    
	@RequestMapping("/sysuser/getLoginName")
	public String getLoginName(@RequestParam(value = "loginName")String loginName,@RequestParam(value = "password")String password);
	
	@RequestMapping("/sysuser/findLoginName")
	public String findLoginName(@RequestParam(value = "loginName")String loginName);
	
}
