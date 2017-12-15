package cn.ucai.weike.dto;

import java.io.Serializable;


public class UacUserRoleDto implements Serializable{

	private Integer id;
	private UacUserDto uacUserDto;
	private UacRoleDto uacRoleDto;
	
	public UacUserRoleDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UacUserRoleDto(Integer id, UacUserDto uacUserDto,
			UacRoleDto uacRoleDto) {
		super();
		this.id = id;
		this.uacUserDto = uacUserDto;
		this.uacRoleDto = uacRoleDto;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UacUserDto getUacUserDto() {
		return uacUserDto;
	}
	public void setUacUserDto(UacUserDto uacUserDto) {
		this.uacUserDto = uacUserDto;
	}
	public UacRoleDto getUacRoleDto() {
		return uacRoleDto;
	}
	public void setUacRoleDto(UacRoleDto uacRoleDto) {
		this.uacRoleDto = uacRoleDto;
	}
	
	
}
