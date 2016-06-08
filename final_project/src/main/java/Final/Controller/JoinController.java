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
	
	//MemberDAO.java에서 정의된 memberDAO의 객체 dao를 가져와 현재 클래스에서 사용가능한 dao객체에 저장
	public void setDao(joinDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/joinPage/join.do")
	
	public String join()
	{
		
		return "join";
	}
}
