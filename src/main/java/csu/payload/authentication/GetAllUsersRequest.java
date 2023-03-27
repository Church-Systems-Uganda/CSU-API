package csu.payload.authentication;

import csu.model.general.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GetAllUsersRequest {

	 // The user's first name
	@NotBlank
	@Size(min = 2, max = 40)
	private String firstname;

    // The user's last name
	@NotBlank
	@Size(min = 2, max = 40)
	private String surname;

    // The user's chosen username
	@NotBlank
	@Size(min = 3, max = 15)
	private String username;

    // The user's email address
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

    // The user's chosen password
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

    // The role assigned to the user
	private RoleName roleName;

	public GetAllUsersRequest(@NotBlank @Size(min = 2, max = 40) String firstname,
			@NotBlank @Size(min = 2, max = 40) String surname, @NotBlank @Size(min = 3, max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(min = 6, max = 20) String password,
			RoleName roleName) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
}
