package csu.payload.authentication;

import csu.model.general.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GetAllUsersPayload {
	 
		@NotBlank
		@Size(min = 3, max = 15)
		private String username;

	    // The user's email address
		@NotBlank
		@Size(max = 40)
		@Email
		private String email;



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



		public GetAllUsersPayload() {
			super();
		}


		
}
