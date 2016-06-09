package Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Final.Dao.MemberDao;
import Final.Model.MemberInfo;

	@Controller
	public class IdSearchController {
	
	MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
		
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
