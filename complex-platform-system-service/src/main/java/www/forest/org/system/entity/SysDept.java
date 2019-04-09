package www.forest.org.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_dept")
public class SysDept {

	@TableField(value="id")
	@TableId
	private Long id;
	
	@TableField(value="name")
	private String name;
	
	@TableField(value="parent_id")
	private Long parentId;
	
	@TableField(value="tree_depth")
	private Integer treeDepth;
	
	@TableField(value="is_delete")
	@TableLogic
	private Integer isDelete;
	
	@TableField(value="priority")
	private Integer priority;
	
	@TableField(value="create_time",fill=FieldFill.INSERT_UPDATE)
	private String createTime;
	
	@TableField(value="update_time",fill=FieldFill.UPDATE)
	private String updateTime;
	
	@TableField(value="is_enable")
	private Integer isEnable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getTreeDepth() {
		return treeDepth;
	}

	public void setTreeDepth(Integer treeDepth) {
		this.treeDepth = treeDepth;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	
	
	
}
