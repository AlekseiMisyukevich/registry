package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "e_journal")
public class Role {

	@Id
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;
       
    
    @OneToMany(mappedBy = "role")
    private Set<User> user;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(User userSet) {
		this.user = user;
	}	
	
}
