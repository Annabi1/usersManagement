package com.fithnitek.UserManagement.model;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
     @Id
     @Column(nullable = true, length = 64)
     private String email;
    @Column(nullable = true, length = 64)
    private String firstname;
    @Column(nullable = true, length = 64)
    private String cin;
    @Column(nullable = true, length = 64)
    private String permis;
    @Column()
    private boolean enabled;
    
    @Column(nullable = true, length = 64)
    private String lastname;
	
    @Column(nullable = true, length = 64)
    private String image;
    
  
	@ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      })

    	  private Set<Role> roles = new HashSet<>();

  
	
	

	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPermis() {
		return permis;
	}
	public void setPermis(String permis) {
		this.permis = permis;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User(String email, String firstname, String cin, String permis, boolean enabled, String photos,
			Set<Role> roles, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.cin = cin;
		this.permis = permis;
		this.enabled = enabled;
		this.image = photos;
		this.roles = roles;
		this.lastname = lastname;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Transient
	public String getPhotosImagePath() {
		if(email==null || image ==null ) return "/images/default-user.png";
		return "/user-photos/"+this.firstname+"/"+this.image;
		
	}

    
    
    
    
}
