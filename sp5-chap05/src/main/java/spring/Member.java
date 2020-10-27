package spring;

import java.time.LocalDateTime;

public class Member {

		private Long id;
		private String email;
		private String password;
		private String name;
		private LocalDateTime registerDateTiem;
		
		public Member(String email, String password
				, String name, LocalDateTime regDateTime) {
			this.email = email;
			this.password = password;
			this.name = name;
			this.registerDateTiem = regDateTime;
		}

		void setId(Long id) {
			this.id = id;
		}
		
		public Long getId() {
			return id;
		}

		public String getEmail() {
			return email;
		}


		public String getPassword() {
			return password;
		}


		public String getName() {
			return name;
		}


		public LocalDateTime getRegisterDateTiem() {
			return registerDateTiem;
		}

		public void changePassword(String oldPassword, String newPassword) {
			if(!password.equals(oldPassword)) {
				throw new WrongIdPasswordException();
			}
			this.password = newPassword;
		}
}
