package com.xk.msa.api.mo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:16:34
 *
 */
@Entity
@Table(name = "sysuser")
public class User {
	private String id;
	private String username;
	private String password;
	private Set<UserRole> userroles = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password; 
	}

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	@Column(name = "loginname")
	public String getUsername() {
		return username;
	}

	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	/**
	 * @return the userroles
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserroles() {
		return userroles;
	}

	/**
	 * @param userroles the userroles to set
	 */
	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
 
}
