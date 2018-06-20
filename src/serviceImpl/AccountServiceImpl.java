package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public AccountBean search(AccountBean account) {
		AccountBean temp = new AccountBean();
		for(int i=0;i<list.size();i++) {
			if(account.getUid().equals(list.get(i).getUid()) && account.getPass().equals(list.get(i).getPass())) {
				temp = list.get(i);
				break;
			}
		}
		return temp;
	}
	@Override
	public List<AccountBean> search(String word) {
		List<AccountBean> dap = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(word.equals(list.get(i).getName())) {
				dap.add(list.get(i));
			}
		}
		return dap;
	}
	@Override
	public void update(AccountBean account) {
		String newPass = account.getPass().split("/")[1];
		account.setPass(account.getPass().split("/")[0]);
		list.get(list.indexOf(search(account))).setPass(newPass);
	}

	@Override
	public void delete(AccountBean account) {
		list.remove(list.indexOf(search(account)));
	}
}
