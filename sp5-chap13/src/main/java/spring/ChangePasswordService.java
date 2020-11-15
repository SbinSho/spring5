package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

	private MemberDao memberDao;

	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		System.out.println("service 진입완료");
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
