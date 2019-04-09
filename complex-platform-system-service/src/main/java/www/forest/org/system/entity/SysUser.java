package www.forest.org.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_user")
public class SysUser  implements Serializable{

	@TableField(value="id")
	private Long id;
	
	
	@TableField(value="login_name")
	private String loginName;
	
	@TableField(value="password")
	private String password;
	
	@TableField(value="create_time",fill=FieldFill.INSERT_UPDATE)
	private String createTime;
	
	@TableField(value="update_time",fill=FieldFill.UPDATE)
	private String updateTime;
	
	@TableField(value="is_delete")
	@TableLogic
	private int isDelete;
	
	@TableField(value="is_status")
	private int isStatus;
	
	@TableField(value="name")
    private String name;
	
	@TableField(value="login_time")
    private String loginTime;
	
	@TableField(value="phone")
	private String phone;
	
	@TableField(value="mail")
	private String mail;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
	
}
