package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Final.Dao.FileLoadDao;

@Controller
public class BoardController {

	
	private FileLoadDao fileLoadDao;
	private MemberDao memberDao;

	@Autowired
	public void setFileLoadDao(FileLoadDao fileLoadDao) {
		this.fileLoadDao = fileLoadDao;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("/modify.do")
	public String modifyForm(){
		
		     
		return "modifyForm";
	}
	
	@RequestMapping("/delete.do")
	public String delete(String title){
		int success = fileLoadDao.delete(title);
		
		if (success>0) {
			return "board";
		}
		
		return "";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session!=null) {
			session.invalidate();
		}
		return "main";
	}
}
