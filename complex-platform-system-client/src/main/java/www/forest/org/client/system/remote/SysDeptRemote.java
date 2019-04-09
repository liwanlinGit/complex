package www.forest.org.client.system.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="complex-platform-system-service")
public interface SysDeptRemote {

	@RequestMapping("/sysdept/getList")
	public String getList();
	
	
}
