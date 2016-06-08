package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Final.Dao.FileLoadDao;
import Final.Dao.MemberDao;
import Final.Model.FileInfo;
import Final.Model.MemberInfo;

@Controller
public class MemberController 
{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private FileLoadDao fileLoadDao;

	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}



	public void setFileLoadDao(FileLoadDao fileLoadDao) {
		this.fileLoadDao = fileLoadDao;
	}



	@RequestMapping("/joinPage/join.do")
	public String join()
	{
		
		return "join";
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
