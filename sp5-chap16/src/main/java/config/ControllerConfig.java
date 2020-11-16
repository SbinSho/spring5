 package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberDetailController;
import controller.MemeberListController;
import controller.RegisterController;
import controller.RestMemberController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
import survey.SurveyContorller;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegsvc;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private MemberDao memberDao;
	
	
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
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
		
	}
	
	@Bean
	public MemeberListController memberListController() {
		MemeberListController controller = new MemeberListController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public RestMemberController restApi() {
		RestMemberController cont = new RestMemberController();
		cont.setMemberDao(memberDao);
		cont.setRegisterServce(memberRegsvc);
		return cont;
		
	}
	
}
