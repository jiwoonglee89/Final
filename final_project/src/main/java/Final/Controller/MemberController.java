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
	
	//�α��� ȭ�� �̵�(id ���翩�ο����� view ����)
	@RequestMapping("/loginForm.do")
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		System.out.println(id);

		return "loginPage/loginForm";
	}
	//�α��� �ϱ�
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
	
	
	//�ּҷ� �˻� ȭ������ �̵�
	@RequestMapping(value="/zipCheck.do",method=RequestMethod.GET)
	public String zipcheck()
	{
		
		return "joinPage/zipCheck";
	}
	//DB���� �˻��� �� �����ͼ� ǥ��
	@RequestMapping(value="/zipCheck.do",method=RequestMethod.POST)
	public String zipcheckPro()
	{
		
		return "joinPage/zipCheck";
	}
	
	
	
	//ȸ������ ȭ������ �̵� 
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String joinMove()
	{
		return "joinPage/join";
	}
	//ȸ������ �� �������� �̵�
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join()
	{
		return "joinPage/loginForm";
	}
	//���̵�ͺ�й�ȣ ã�� ȭ������ �̵�
	@RequestMapping("/idpwSearchNew.do")
	public String idpwSearchNew() {
		return "loginPage/idpwSearchNew";
	}
	//���̵� �ߺ�ȭ�� ���� 
	@RequestMapping("/confirmId.do")
	public String confirmID(Model model, HttpServletRequest request) {
		System.out.println(request.getRequestURL());
		// ���̵� �ߺ� ���� ����
		int check = 0;
		// view���� ���� id���� �� �޾Ƽ� Stirng ������ id ������ ����
		String id = request.getParameter("id");
		MemberInfo member = null;
		// DB���� ID�ִ��� Ȯ��
		member = memberDao.getMember(id);

		if (member == null) {
			// DB�� ID�� ���°��
			check = 1;

		} else {
			// DB�� ID�� �ִ� ���
			check = 0;
		}
		model.addAttribute("check", check);
		return "joinPage/confirmId";
	}
	//ȸ�� ���� ���� ȭ�� �̵�
	@RequestMapping("/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ModelAndView mav = new ModelAndView("modifyForm");
		MemberInfo member = memberDao.getMember(id);

		mav.addObject("memberInfo", member);

		return mav;
	}
	//ȸ�� ���� ���� �Ϸ��� ���������� �̵�
	@RequestMapping("/modify.do")
	public String modify(@ModelAttribute("memberInfo") MemberInfo memberInfo) {

		int success = memberDao.modify(memberInfo);

		if (success > 0) {
			return "board";
		}
		return "login";
	}
	//ȸ�� Ż��
	@RequestMapping("/delete.do")
	public String delete(String title) {
		int success = fileLoadDao.delete(title);

		if (success > 0) {
			return "board";
		}

		return "";
	}
	//�α׾ƿ�
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "loginPage/loginForm";
	}
	//����˻�ȭ������ �̵�
	@RequestMapping(value="/zipcode.do", method=RequestMethod.GET)
	public String moveZipView()
	{
		return "joinPage/zipcode";
	}
	//�����ȣ �˻�
	@RequestMapping(value="/zipcode.do", method=RequestMethod.POST)
	public String zipcodePro(HttpServletRequest request, Model model)
	{
		String area4 = request.getParameter("area4");
		//ZipcodeDao zipcodeDao = zipcodeDao.zipcodeSerach();
		
		return "joinPage/zipcode";
	}
}
