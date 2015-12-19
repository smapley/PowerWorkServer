package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserBase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User_Base", catalog = "PowerWork")
public class UserBase implements java.io.Serializable {

	// Fields

	private Integer useId;
	private String username;
	private String password;
	private String skey;
	private Timestamp refresh;
	private Integer state;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public UserBase() {
	}

	/** full constructor */
	public UserBase(String username, String password, String skey,
			Timestamp refresh, Integer state, Set<User> users) {
		this.username = username;
		this.password = password;
		this.skey = skey;
		this.refresh = refresh;
		this.state = state;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "use_id", unique = true, nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "skey")
	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	@Column(name = "refresh", length = 19)
	public Timestamp getRefresh() {
		return this.refresh;
	}

	public void setRefresh(Timestamp refresh) {
		this.refresh = refresh;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBase")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}