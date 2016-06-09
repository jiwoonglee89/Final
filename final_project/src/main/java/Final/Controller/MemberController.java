package Final.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Final.Dao.FileLoadDao;
import Final.Dao.MemberDao;
import Final.Model.MemberInfo;

@Controller
public class MemberController {
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
	public MemberInfo memberInfo() {
		return new MemberInfo();
	}

	@RequestMapping("/loginForm.do")
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		System.out.println(id);

		return "loginPage/loginForm";
	}

	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join()
	{
		return "joinPage/join";
		
	}

	@RequestMapping(value="/join.do", method="post")
	public String join()
	{
		
		return "joinPage/loginForm";
	}

	@RequestMapping("/idpwSearchNew.do")
	public String idpwSearchNew() {
		return "loginPage/idpwSearchNew";
	}

	@RequestMapping("/confirmId.do")
	public String confirmID(Model model, HttpServletRequest request) {
		System.out.println(request.getRequestURL());
		// 아이디 중복 여부 변수
		int check = 0;
		// view에서 받은 id변수 값 받아서 Stirng 형식의 id 변수에 저장
		String id = request.getParameter("id");
		MemberInfo member = null;
		// DB에서 ID있는지 확인
		member = memberDao.getMember(id);

		if (member == null) {
			// DB에 ID가 없는경우
			check = 1;

		} else {
			// DB에 ID가 있는 경우
			check = 0;
		}
		model.addAttribute("check", check);
		return "joinPage/confirmId";
	}

	@RequestMapping("/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ModelAndView mav = new ModelAndView("modifyForm");
		MemberInfo member = memberDao.getMember(id);

		mav.addObject("memberInfo", member);

		return mav;
	}

	@RequestMapping("/modify.do")
	public String modify(@ModelAttribute("memberInfo") MemberInfo memberInfo) {

		int success = memberDao.modify(memberInfo);

		if (success > 0) {
			return "board";
		}
		return "login";
	}

	@RequestMapping("/delete.do")
	public String delete(String title) {
		int success = fileLoadDao.delete(title);

		if (success > 0) {
			return "board";
		}

		return "";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "login";
	}
}
