package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String form1(){
		
		return "idpwSearchNew";
	}
	
	@RequestMapping("/pwSearch.do")
	public String action1(MemberInfo memberInfo, Model model){
	
		String pw = memberDao.pwSearch(memberInfo);
		model.addAttribute("pw", pw);
	
		return "pwSearch";
	}
/*	@RequestMapping("/idSearch.do")
	public String form(){
		return"idpwSearchNew";
	}*/
	
	@RequestMapping("/idSearch.do")
	public String requestPro11(HttpServletRequest request,HttpServletResponse response, MemberInfo memberInfo, Model model){
		
		String id = memberDao.idSearch(memberInfo);
		model.addAttribute("id", id);
		
		String message = "";
		if(id.isEmpty()){
			message="일치하는 아이디가 없습니다.";
			model.addAttribute("message",message);
		} else{
			message=null;
			model.addAttribute("message",message);
			model.addAttribute("id", id); 
			}
		
		return "idSearch";
	}
}
