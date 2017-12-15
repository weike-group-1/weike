package cn.ucai.weike.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UacRoleRight entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uac_role_right", catalog = "weike")
public class UacRoleRight implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacRole uacRole;
	private UacRight uacRight;

	// Constructors

	/** default constructor */
	public UacRoleRight() {
	}

	/** full constructor */
	public UacRoleRight(UacRole uacRole, UacRight uacRight) {
		this.uacRole = uacRole;
		this.uacRight = uacRight;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uac_id")
	public UacRole getUacRole() {
		return this.uacRole;
	}

	public void setUacRole(UacRole uacRole) {
		this.uacRole = uacRole;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uac_right_id")
	public UacRight getUacRight() {
		return this.uacRight;
	}

	public void setUacRight(UacRight uacRight) {
		this.uacRight = uacRight;
	}

}