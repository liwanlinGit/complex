package www.forest.org.system.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import www.forest.org.common.util.JsonUtil;
import www.forest.org.system.entity.SysUser;
import www.forest.org.system.mapper.SysUserMapper;

@RestController
@RequestMapping("/sysuser")
public class SysUserAction {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@RequestMapping("/getList")
	public String getList() {
		QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
		List<SysUser> sysUserList = sysUserMapper.selectList(queryWrapper);
		return JsonUtil.toJson(sysUserList);
	}
	
	@RequestMapping("/getLoginName")
	public String getUserName(String loginName,String password) {
		long time1=System.currentTimeMillis();
		
		QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("login_name", loginName);
		queryWrapper.eq("password", password);
		SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
		long time2=System.currentTimeMillis();
		System.out.println("f服务端端耗时===="+(time2-time1));
		return JsonUtil.toJson(sysUser);
	}
	
	@RequestMapping("/findLoginName")
	public String findLoginName(String loginName) {
		QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("login_name", loginName);
		SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
		return JsonUtil.toJson(sysUser);
	}
	
}
