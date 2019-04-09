package www.forest.org.client.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.forest.org.client.system.remote.SysDeptRemote;
import www.forest.org.client.system.service.SysDeptService;

@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {

	@Autowired
	private SysDeptRemote sysDeptRemote;

	@Override
	public String getList() {
		return sysDeptRemote.getList();
	}
	
}
