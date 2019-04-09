package www.forest.org.system.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import www.forest.org.common.util.JsonUtil;
import www.forest.org.system.entity.SysPermissions;
import www.forest.org.system.mapper.SysPermissionsMapper;

@RestController
@RequestMapping("/syspermissions")
public class SysPermissionsAction {

	@Autowired
	private SysPermissionsMapper sysPermissionsMapper;
	
	@RequestMapping("/getLevelByPermissions")
	public String getLevelByPermissions(Integer level,Long parentId) {
		QueryWrapper<SysPermissions> queryWrapper=new QueryWrapper<SysPermissions>();
		/*queryWrapper.eq("tree_depth", level);
		queryWrapper.eq("parent_id", parentId);
		queryWrapper.orderByAsc("priority");*/
		queryWrapper.last(" and FIND_IN_SET(id,queryChildrenPermission(0))");
		List<SysPermissions> permissionsList = sysPermissionsMapper.selectList(queryWrapper);
		return JsonUtil.toJson(permissionsList);
	}
	
}
