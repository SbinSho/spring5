package spring;

public class MemberInfoPrinter {

	private MemberDao membDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = membDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음 \n");
			return;
		}
		printer.print(member);
		System.out.println();
	}

	public void setMembDao(MemberDao membDao) {
		this.membDao = membDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	
	
	
}
