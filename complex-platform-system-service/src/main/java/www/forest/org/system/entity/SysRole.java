package www.forest.org.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_role")
public class SysRole {

	@TableField(value="id")
	private Long id;
	
	@TableField(value="role_name")
	private String roleName;
	
	@TableField(value="role_remark")
	private String roleRemark;
	
	@TableField(value="update_time",fill=FieldFill.UPDATE)
	private String updateTime;
	
	@TableField(value="create_time",fill=FieldFill.INSERT_UPDATE)
	private String createTime;
	
	@TableField(value="is_delete")
	@TableLogic
	private int isDelete;
	
	@TableField(value="is_status")
	private int isStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}
	
	
	
	
}
