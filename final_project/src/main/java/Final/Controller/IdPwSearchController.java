package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Final.Dao.MemberDao;
import Final.Model.MemberInfo;


	

	@Controller
	public class IdPwSearchController  {
	
	@Autowired
	MemberDao memberDao;
	
	
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
		
	}
	
	@RequestMapping("/pwSearch.do")
	public String action1(MemberInfo memberInfo, Model model){
		
		System.out.println(memberInfo.getPassword());
		String pw = memberDao.pwSearch(memberInfo);

		if(pw==null){
			String message="비밀번호를 확인해 주세요.";
			model.addAttribute("message",message);
		}else {
			String message = null;
			model.addAttribute("message", message);
			model.addAttribute("pw", pw);
		}
	
		return "/loginPage/pwSearch";
	}
	
	@RequestMapping("/idSearch.do")
	public String requestPro11(HttpServletRequest request,HttpServletResponse response, MemberInfo memberInfo, Model model){
		
		System.out.println(memberInfo.getName());
		String id = memberDao.idSearch(memberInfo);
	
		
		if(id==null){
			String message="일치하는 아이디가 없습니다.";
			model.addAttribute("message",message);
		} else{
			String message=null;
			model.addAttribute("message",message);
			model.addAttribute("id", id);
			}
		
		return "/loginPage/idSearch";
	}
}
