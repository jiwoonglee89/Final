package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@ModelAttribute("memberInfo")
	public MemberInfo memberInfo(){
		return new MemberInfo();
	}
	
	@RequestMapping("/loginForm.do")
	public String login()
	{
		return "loginPage/loginForm";
	}


	@RequestMapping("/join.do")
	public String join()
	{
		
		
		return "joinPage/join";
	}
	

	@RequestMapping("/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request){
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ModelAndView mav = new ModelAndView("modifyForm");
		MemberInfo member = memberDao.getMember(id);
		
		mav.addObject("memberInfo", member);
		     
		return mav;
	}
	
	@RequestMapping("/modify.do")
	public String modify(@ModelAttribute("memberInfo")MemberInfo memberInfo){
		
		int success = memberDao.modify(memberInfo);
		
		if (success>0) {
			return "board";
		}
		return "login";
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
		return "login";
	}
}
