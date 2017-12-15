package cn.ucai.weike.dto;


public class UacRoleRightDto {
	
	private Integer id;
	private UacRoleDto uacRoleDto;
	private UacRightDto uacRightDto;
	
	public UacRoleRightDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UacRoleRightDto(Integer id,UacRoleDto uacRoleDto, UacRightDto uacRightDto) {
		super();
		this.id=id;
		this.uacRoleDto = uacRoleDto;
		this.uacRightDto = uacRightDto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UacRoleDto getUacRoleDto() {
		return uacRoleDto;
	}
	public void setUacRoleDto(UacRoleDto uacRoleDto) {
		this.uacRoleDto = uacRoleDto;
	}
	public UacRightDto getUacRightDto() {
		return uacRightDto;
	}
	public void setUacRightDto(UacRightDto uacRightDto) {
		this.uacRightDto = uacRightDto;
	}
	
	
	
	

}
