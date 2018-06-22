package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
public class MemberController {
	public void join() {//유저
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		member = new UserBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드"));
		member.setSsn(JOptionPane.showInputDialog("주민번호"));
		member.setAddr(JOptionPane.showInputDialog("주소"));
		member.setPhone(JOptionPane.showInputDialog("폰번호"));
		service.createUser((UserBean) member);
	}
	public void add() {//직원
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드"));
		member.setSsn(JOptionPane.showInputDialog("주민번호"));
		member.setAddr(JOptionPane.showInputDialog("주소"));
		member.setPhone(JOptionPane.showInputDialog("폰번호"));
		//service.createStaff((StaffBean) member);
		
	}
	public void list() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		//service.list();
	}
	public void findById() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드"));
		//JOptionPane.showMessageDialog(null,service.findById(member));
	}
	public void findByName() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}
	public void count() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		//JOptionPane.showMessageDialog(null, service.selectCount());
	}
	public void update() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드")
				+
				"/"
				+
				JOptionPane.showInputDialog("새 패스워드"));
		service.updatePass(member);
	}
	public void withdrawal() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드")
				+
				"/"
				+
				JOptionPane.showInputDialog("패스워드 확인")
				);
		service.deleteMember(member);
	}
}
