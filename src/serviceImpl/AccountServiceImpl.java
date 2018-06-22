package serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	private List<AccountBean> list;
	public AccountServiceImpl() {
		list = new ArrayList<>();
	}
	@Override
	public void createAccount(AccountBean account) {
		account.setCreateDate("4321");
		account.setAccountType("기본통장");
		account.setAccountNo("1234");
		list.add(account);
	}
	@Override
	public void createMinus(MinusAccountBean minusAccount) {
		minusAccount.setCreateDate("4321");
		minusAccount.setAccountType("마이너스통장");
		minusAccount.setAccountNo("1234");
		list.add(minusAccount);
	}
	@Override
	public AccountBean findAccountById(AccountBean account) {
		AccountBean temp = new AccountBean();
		String uid = account.getUid();
		String pass = account.getPass();
		temp = list.get(list.indexOf(account));
		if(temp == null) {
			System.out.println("null");
		}else if(!temp.getPass().equals(pass)) {
			System.out.println("패스가달라");
		}else {
			System.out.println("찾기완료");
		}
		return temp;
	}
	@Override
	public void updatePass(AccountBean account) {
		String id = account.getUid();
		String newPass = account.getPass().split("/")[1];
		account.setPass(account.getPass().split("/")[0]);
		AccountBean ab = findAccountById(account);
		if(ab == null) {
			System.out.println("없는 아이디입니다.");
		}else {
			ab.setPass(newPass);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		AccountBean ab = findAccountById(account);
		if(ab == null) {
			System.out.println("없는 아이디");
		}else {
			list.remove(list.indexOf(ab));
		}
	}
}
