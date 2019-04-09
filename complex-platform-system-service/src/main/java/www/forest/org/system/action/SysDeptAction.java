package www.forest.org.system.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import www.forest.org.common.util.JsonUtil;
import www.forest.org.system.entity.SysDept;
import www.forest.org.system.entity.SysUser;
import www.forest.org.system.mapper.SysDeptMapper;

@RestController
@RequestMapping("/sysdept")
public class SysDeptAction {

	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	@RequestMapping("/getList")
	public String getList() {
		QueryWrapper<SysDept> queryWrapper=new QueryWrapper<>();
		List<SysDept> sysDeptList = sysDeptMapper.selectList(queryWrapper);
		return JsonUtil.toJson(sysDeptList);
	}
	
}
