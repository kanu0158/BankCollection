package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum AdminButt {
		EXIT,
		ADD,
		LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,
		UPDATE,
		REMOVE;
}
public class AdminController {
	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		MemberBean member = null; 
		while(true) {
			switch((AdminButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AdminButt[] { AdminButt.EXIT,AdminButt.ADD, AdminButt.LIST, AdminButt.FIND_BY_ID, AdminButt.FIND_BY_NAME,AdminButt.COUNT, AdminButt.UPDATE,  AdminButt.REMOVE},
					null)) {
			case EXIT:return;
			case ADD:
				break;
			case LIST:
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case COUNT:
				break;
			case UPDATE:
				break;
			case REMOVE:
				break;
			default:break;
			}
		}
	}
}
