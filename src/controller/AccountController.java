package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {
	public void account() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		acb = new AccountBean();
		acb.setName(JOptionPane.showInputDialog("name"));
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		service.createAccount(acb);
	}
	public void minusAccount() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		acb = new MinusAccountBean();
		acb.setName(JOptionPane.showInputDialog("name"));
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		((MinusAccountBean) acb).setLimit(JOptionPane.showInputDialog("limit"));
		service.createMinus((MinusAccountBean) acb);
	}
	public void list() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		//service.list();
	}
	public void findById() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		//JOptionPane.showMessageDialog(null, service.findById(acb));
	}
	public void findByName() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}
	public void minusList() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
	}
	public void changePass() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass") + "/" + JOptionPane.showInputDialog("newPass"));
		service.updatePass(acb);
	}
	public void deleteAccount() {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null;
		acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		service.deleteAccount(acb);
	}
}
