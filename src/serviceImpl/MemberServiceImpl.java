package serviceImpl;

import java.util.*;
import domain.*;
import service.MemberService;

public class MemberServiceImpl implements MemberService{ // list - > map 으로 하는 예제
	List<MemberBean> list;//아이디를 키값으로 줌
	
	public MemberServiceImpl() {
		list = new ArrayList<>();//뒤는 생략 가능
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRate("7등급");
		list.add(user);
	}
	@Override
	public String login(UserBean member) {
		return "";
	}
	@Override
	public void updatePass(MemberBean member) {
		String id = member.getUid();
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		MemberBean mem = null;
		for(MemberBean e : list) {
			if(id.equals(e.getUid()) && oldPass.equals(e.getPass())) {
				mem = e;
			}
		}
		
		if(mem == null) {
			System.out.println("수정하려는 id가 없음");
		}else {
			if(oldPass.equals(mem.getPass())) {
				mem.setPass(newPass);
			}
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		//map.remove(findById(member).getUid());
		String id = member.getUid();
		String pass = member.getPass();
		for(MemberBean e : list) {
			if(id.equals(e.getUid()) && pass.equals(e.getPass())) {
				list.remove(e);
			}
		}
	}
}
