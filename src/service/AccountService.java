package service;

import java.util.List;

import domain.*;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinus(MinusAccountBean minusAccount);
	public List<AccountBean> list();
	public AccountBean search(AccountBean account);
	public List<AccountBean> search(String word);
	public void update(AccountBean account);
	public void delete(AccountBean account);
}
