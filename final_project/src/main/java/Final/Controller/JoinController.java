package Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Final.Dao.joinDao;
import Final.Model.MemberInfo;

@Controller
public class JoinController 
{
	@Autowired
	joinDao dao;
	
	@Autowired
	MemberInfo dto;
	
	//MemberDAO.java���� ���ǵ� memberDAO�� ��ü dao�� ������ ���� Ŭ�������� ��밡���� dao��ü�� ����
	public void setDao(joinDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/joinPage/join.do")
	
	public String join()
	{
		
		return "join";
	}
}
