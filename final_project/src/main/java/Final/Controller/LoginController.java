package Final.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.net.httpserver.Authenticator;

import Final.Dao.MemberDao;
import Final.Model.MemberInfo;

@Controller
@RequestMapping("loginForm.do")
public class LoginController {
	
	MemberDao memberDao = new MemberDao();
	
	@Autowired
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
		}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		
		return "loginform";
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, MemberInfo memberInfo){
		String id = request.getParameter("id");
		if(memberDao.loginSuccess(memberInfo).isEmpty()){
			return "loginForm";
		
		}else{
			request.getSession().getAttribute(id);
			return "loginPro";
		}
	}
}

