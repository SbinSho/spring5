 package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import spring.AuthService;
import spring.MemberRegisterService;
import survey.SurveyContorller;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegsvc;
	
	@Autowired
	private AuthService authService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterServce(memberRegsvc);
		return controller;
	}
	
	@Bean
	public SurveyContorller surveyController() {
		return new SurveyContorller();
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	
}
