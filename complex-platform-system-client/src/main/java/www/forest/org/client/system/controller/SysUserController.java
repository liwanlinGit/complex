package www.forest.org.client.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.forest.org.client.system.service.SysUserService;
import www.forest.org.common.client.TokenAuthenticationService;
import www.forest.org.common.util.ResultMessage;
import www.forest.org.common.util.StringUtil;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	
	@RequestMapping("/login")
	public Map<String, Object> getLoginName(String loginName,String password) {
		long time1=System.currentTimeMillis();
		String sysUser = sysUserService.getLoginName(loginName, password);
		long time2=System.currentTimeMillis();
		System.out.println("客户端耗时===="+(time2-time1));
		if(!StringUtil.isBlank(sysUser)) {
			if(ResultMessage.ERROR_CODE.equals(sysUser)) {
				return ResultMessage.result(ResultMessage.RESULT_500, ResultMessage.ERROR_CODE);
			}else {
				String jwt = TokenAuthenticationService.addAuthentication(loginName);
				return ResultMessage.result(jwt, ResultMessage.SUCCESS_CODE);
			}
		}else {
			return ResultMessage.result(ResultMessage.RESULT_NO, ResultMessage.SUCCESS_CODE_204);
		}
	}
	//判断是否登录，这个方法主要是获取当前登录用户信息，其实可以把用户信息放入到jwt中，此处jwt只放入了登录名
	//zuul 网关回去判断token校验，所以这里的判断token多余，只需要获取用户名信息即可
	@RequestMapping("/check")
	public Map<String, Object> check(HttpServletRequest request) {
		String token = request.getHeader("token");
		if(!StringUtil.isBlank(token)) {
			try {
				String userName = TokenAuthenticationService.getAuthenticationUser(request);
				if(!StringUtil.isBlank(userName)) {
					String user = sysUserService.findLoginName(userName);
					return ResultMessage.result(user);
				}else {
					return ResultMessage.result(ResultMessage.USERNAME_NULL,ResultMessage.ERROR_CODE_503);
				}
			} catch (Exception e) {
				return ResultMessage.result(ResultMessage.TOKEN_FAIL,ResultMessage.ERROR_CODE_503);
			}
			
		}else{
			return ResultMessage.result(ResultMessage.TOKEN_NO,ResultMessage.ERROR_CODE_503);
		}
	}
	
}
