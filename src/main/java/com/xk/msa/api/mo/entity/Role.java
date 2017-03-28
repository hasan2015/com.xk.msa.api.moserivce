package com.xk.msa.api.mo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:16:34
 *
 */
@Entity
@Table(name = "sysrole")
public class Role {
	private String id;
	private String rolename;
	private String tenantid;
	private Set<UserRole> userroles = new HashSet<UserRole>(0);

	public Role() {
	}

	public Role(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "roleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	/**
	 * @return the rolename
	 */
	@Column(name = "rolename")
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename
	 *            the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userroles
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserRole> getUserroles() {
		return userroles;
	}

	/**
	 * @param userroles
	 *            the userroles to set
	 */
	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}

	/**
	 * @return the tenantid
	 */
	@Column(name = "tenantid")
	public String getTenantid() {
		return tenantid;
	}

	/**
	 * @param tenantid the tenantid to set
	 */
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

}
