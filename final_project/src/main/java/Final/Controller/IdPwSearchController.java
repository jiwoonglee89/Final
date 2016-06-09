package Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Final.Dao.MemberDao;
import Final.Model.MemberInfo;

	@Controller
	public class IdPwSearchController {
	
	MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
		
	}
	@RequestMapping("pwSearch.do")
	public String form1(){
		
		return "idpwSearchNew";
	}
	
	@RequestMapping("pwSearchPro.do")
	public String action1(MemberInfo memberInfo, Model model){
	
		String pw = memberDao.pwSearch(memberInfo);
		model.addAttribute("pw", pw);
	
		return "pwSearch";
	}
	@RequestMapping("idSearch.do")
	public String form(){
		return"idpwSearchNew";
	}
	
	@RequestMapping("idSearchPro.do")
	public String action(MemberInfo memberInfo, Model model){
		
		String id = memberDao.idSearch(memberInfo);
		model.addAttribute("id", id);
		
		return "idSearch";
	}
}
