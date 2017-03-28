package com.xk.msa.api.mo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:16:47
 *
 */
@Entity
@Table(name = "sysuserrole")
public class UserRole {
	private String id;
	private User user;
	private Role role;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "userroleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleid")
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
