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
import Final.Dao.ZipcodeDao;
import Final.Model.MemberInfo;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private FileLoadDao fileLoadDao;
	@Autowired
	private ZipcodeDao zipcodeDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setFileLoadDao(FileLoadDao fileLoadDao) {
		this.fileLoadDao = fileLoadDao;
	}
	
	public void setZipcodeDao(ZipcodeDao zipcodeDao)
	{
		this.zipcodeDao = zipcodeDao;
	}

	@ModelAttribute("memberInfo")
	public MemberInfo memberInfo() {
		return new MemberInfo();
	}
	
	//로그인 화면 이동(id 존재여부에따라 view 나뉨)
	@RequestMapping("/loginForm.do")
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		System.out.println(id);

		return "loginPage/loginForm";
	}
	//로그인 하기
	@RequestMapping("/login.do")
	public String loginPro(Model model,HttpServletRequest request)
	{
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		System.out.println(id);
		
		MemberInfo memberInfo = memberDao.getMember(id);
		if (memberInfo !=null) 
		{
			if(memberInfo.getPassword().equals(pass))
			{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
			}
		}
		return "loginPage/loginForm";
	}
	
	
	//주소록 검색 화면으로 이동
	@RequestMapping(value="/zipCheck.do",method=RequestMethod.GET)
	public String zipcheck()
	{
		
		return "joinPage/zipCheck";
	}
	//DB에서 검색된 값 가져와서 표시
	@RequestMapping(value="/zipCheck.do",method=RequestMethod.POST)
	public String zipcheckPro()
	{
		
		return "joinPage/zipCheck";
	}
	
	
	
	//회원가입 화면으로 이동 
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String joinMove()
	{
		return "joinPage/join";
	}
	//회원가입 후 메인으로 이동
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join()
	{
		return "joinPage/loginForm";
	}
	//아이디와비밀번호 찾는 화면으로 이동
	@RequestMapping("/idpwSearchNew.do")
	public String idpwSearchNew() {
		return "loginPage/idpwSearchNew";
	}
	//아이디 중복화면 관련 
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
	//회원 정보 수정 화면 이동
	@RequestMapping("/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ModelAndView mav = new ModelAndView("modifyForm");
		MemberInfo member = memberDao.getMember(id);

		mav.addObject("memberInfo", member);

		return mav;
	}
	//회원 정보 수정 완료후 마이페이지 이동
	@RequestMapping("/modify.do")
	public String modify(@ModelAttribute("memberInfo") MemberInfo memberInfo) {

		int success = memberDao.modify(memberInfo);

		if (success > 0) {
			return "board";
		}
		return "login";
	}
	//회원 탈퇴
	@RequestMapping("/delete.do")
	public String delete(String title) {
		int success = fileLoadDao.delete(title);

		if (success > 0) {
			return "board";
		}

		return "";
	}
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "loginPage/loginForm";
	}
	//우편검색화면으로 이동
	@RequestMapping(value="/zipcode.do", method=RequestMethod.GET)
	public String moveZipView()
	{
		return "joinPage/zipcode";
	}
	//우편번호 검색
	@RequestMapping(value="/zipcode.do", method=RequestMethod.POST)
	public String zipcodePro(HttpServletRequest request, Model model)
	{
		String area4 = request.getParameter("area4");
		//ZipcodeDao zipcodeDao = zipcodeDao.zipcodeSerach();
		
		return "joinPage/zipcode";
	}
}
