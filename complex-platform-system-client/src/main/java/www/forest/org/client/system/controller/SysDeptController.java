package www.forest.org.client.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.forest.org.client.system.service.SysDeptService;
import www.forest.org.common.util.StringUtil;

@RestController
@RequestMapping("/sysdept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;
	
	@RequestMapping("/getList")
	public String getList() {
		String list = sysDeptService.getList();
		if(!StringUtil.isBlank(list)) {
			return list;
		}
		return null;
	}
}
