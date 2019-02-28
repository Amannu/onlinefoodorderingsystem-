package com.g39.onlinefoodorderingsystem.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank(message = "Please provide a username")
    private String username;
	@Size(min = 5, message = "Your password must have at least 5 characters")
    @NotBlank(message = "Please provide your password")
    private String password;
	
	@Column(name = "first_name")
    @NotBlank(message = "Please provide your first name")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Please provide your last name")
    private String lastName;
    @Pattern(regexp="^[0-9]{3}-[0-9]{3}-[0-9]{4}$", message="Must be formatted XXX-XXX-XXXX")
    @NotBlank(message="Phone number is required")
    private String phoneNumber;
    @Column(name = "enabled")
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_role", 
    			joinColumns= {@JoinColumn(name="user_id")},
    			inverseJoinColumns= {@JoinColumn(name="role_id")})
    
    private Set<Role> roles;
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<GrantedAuthority> authorities = roles
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet());
		
		return authorities;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	

	public void setPassword(String password) {
		this.password=password;
		
	}

	public void setEnabled(int i) {
		this.enabled=i;
		
	}

	public void setRoles(HashSet<Role> hashSet) {
		this.roles=hashSet;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}
	

}
