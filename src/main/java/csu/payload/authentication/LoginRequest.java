package csu.payload.authentication;

import jakarta.validation.constraints.NotNull;

public class LoginRequest {

	@NotNull
	private String usernameOrEmail;

	@NotNull
	private String password;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String usernameOrEmail, String password) {
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
