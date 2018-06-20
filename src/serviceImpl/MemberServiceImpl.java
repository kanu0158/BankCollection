package serviceImpl;

import java.util.List;
import java.util.ArrayList;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;
	
	public MemberServiceImpl() {
		list = new ArrayList<MemberBean>();//count가 필요가 없어짐!
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRate("7등급");
		System.out.println("실행결과: " + (list.add(user)?"등록성공":"등록실패"));
	}
	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		System.out.println("접근번호" + (list.add(staff)?"등록성공":"등록실패"));
	}
	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public List<MemberBean> search(String param) {
		List<MemberBean> temp = new ArrayList<>();//앞에서 제네릭 줬으면 생략가능
		for(int i=0;i<list.size();i++) {
			if(param.equals(list.get(i).getName())) {//list[i] == list.get(i)
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	@Override
	public MemberBean search(MemberBean member) {
		MemberBean dap = new MemberBean();
		for(int i=0;i<list.size();i++) {
			if(member.getUid().equals(list.get(i).getUid())) {
				dap = list.get(i);
				break;
			}
		}
		return dap;
	}
	@Override
	public void update(MemberBean member) {
		list.get(list.indexOf(search(member))).setPass(member.getPass());
		/*for(int i=0;i<list.size();i++) {
			if(member.getUid().equals(list.get(i).getUid())) {
				search(member).setPass(member.getPass());
			}
		}*/
	}
	@Override
	public void delete(MemberBean member) {
		list.remove(list.indexOf(search(member)));//인덱스 반환 받아서 파라미터로 준 경우
		//list.remove(search(member));//객체 자체를 넘긴 경우
	}
}
