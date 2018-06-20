package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {
enum AccountButt {
		EXIT, ACCOUNT, MINUSACCOUNT, LIST, FIND_BY_ID, FIND_BY_NAME, MINUS_LIST, CHANGE_PASS, DELETE_ACCOUNT;
}

	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		AccountBean acb = null; 
		while(true) {
			switch((AccountButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUSACCOUNT, AccountButt.LIST, AccountButt.FIND_BY_ID, AccountButt.FIND_BY_NAME, AccountButt.MINUS_LIST, AccountButt.CHANGE_PASS, AccountButt.DELETE_ACCOUNT },
					null)) {
			case EXIT:return;
			case ACCOUNT:
				acb = new AccountBean();
				acb.setName(JOptionPane.showInputDialog("name"));
				acb.setUid(JOptionPane.showInputDialog("id"));
				acb.setPass(JOptionPane.showInputDialog("pass"));
				service.createAccount(acb);
				break;
			case MINUSACCOUNT:
				acb = new MinusAccountBean();
				acb.setName(JOptionPane.showInputDialog("name"));
				acb.setUid(JOptionPane.showInputDialog("id"));
				acb.setPass(JOptionPane.showInputDialog("pass"));
				((MinusAccountBean) acb).setLimit(JOptionPane.showInputDialog("limit"));
				service.createMinus((MinusAccountBean) acb);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case FIND_BY_ID:
				/*
				 ID 와 PASS 받아서 일치하면
				 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해
				 */
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("id"));
				acb.setPass(JOptionPane.showInputDialog("pass"));
				JOptionPane.showMessageDialog(null, service.search(acb));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.search(JOptionPane.showInputDialog("이름")));
				break;
			case MINUS_LIST:
				break;
			case CHANGE_PASS:
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("id"));
				acb.setPass(JOptionPane.showInputDialog("pass")
						+
						"/"
						+
						JOptionPane.showInputDialog("newPass")
						);
				service.update(acb);
				break;
			case DELETE_ACCOUNT:
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("id"));
				acb.setPass(JOptionPane.showInputDialog("pass"));
				service.delete(acb);
				break;
			default:break;
			}
		}
	}

}
