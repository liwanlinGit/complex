package www.forest.org.client.system.fallback;

import org.springframework.stereotype.Component;

import www.forest.org.client.system.remote.SysDeptRemote;
import www.forest.org.common.util.ResultMessage;

@Component
public class SysDeptFallBack implements SysDeptRemote {

	@Override
	public String getList() {
		return ResultMessage.ERROR_CODE;
	}

}
