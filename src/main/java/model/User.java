package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "e_journal")

public class User {

	@Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    	//
    }
    
    public User(int id, String username, String password, boolean enabled, Role role) {
    	
    	this.id = id;
    	this.username = username;
    	this.password = password;
    	this.enabled = enabled;
    	this.role = role;
    	
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getUserRoles() {
		return role;
	}

	public void setUserRoles(Role role) {
		this.role = role;
	}

	public User loadUserByUsername(String username2) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
