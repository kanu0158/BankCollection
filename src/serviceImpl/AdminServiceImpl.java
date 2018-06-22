package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import service.*;

public class AdminServiceImpl implements AdminService{
	List<MemberBean> memList;
	List<AccountBean> acList;
	public AdminServiceImpl() {
		memList = new ArrayList<>();
		acList = new ArrayList<>();
	}
	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		memList.add(staff);
	}

	@Override
	public List<MemberBean> memberList() {
		return memList;
	}

	@Override
	public List<MemberBean> findMemberByName(String param) {
		List<MemberBean> temp = new ArrayList();//앞에서 제네릭 줬으면 생략가능
		for(MemberBean e : memList) {
			if(param.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
	}

	@Override
	public MemberBean findMemberById(MemberBean member) {
		return memList.get(memList.indexOf(member));
	}

	@Override
	public List<AccountBean> accountList() {
		return acList;
	}

	@Override
	public List<AccountBean> findAccountByName(String name) {
		List<AccountBean> temp = new ArrayList<>();
		for(AccountBean e : acList) {
			if(name.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.format("%03d", start + ((int)(Math.random() * (end-(start-1)))));
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
	}

	@Override
	public String createAccountNo() {
		String accountNo = "";
		String op = "-";
		for (int i = 0; i < 3; i++) {
			if (i == 2) {
				op = "";
			}
			accountNo += createRandom(0,999) + op;
		}
		return accountNo;
	}//adminservice의 implementation
	
}
