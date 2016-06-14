package Final.Dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.MemberInfo;
import Final.Model.Zipcode;

public class MemberDao extends SqlSessionDaoSupport{

	//아이디 값으로 회원정보 한줄 가져오기
	public MemberInfo getMember(String id){
		return getSqlSession().selectOne("member.one", id);
	}

	public int modify(MemberInfo memberInfo) {
		return getSqlSession().update("member.modify",memberInfo);
	}
public String idSearch(MemberInfo memberInfo) {
		
		return getSqlSession().selectOne("member.idSearch", memberInfo);
	}
	
	public String pwSearch (MemberInfo memberInfo) {
		
		return getSqlSession().selectOne("member.pwSearch", memberInfo);
	}
	
	public String loginSuccess(MemberInfo memberInfo) {
		String password = null;
		
		password = getSqlSession().selectOne("member.loginSucess", memberInfo);
		
		return password;
	}
	public int insert(MemberInfo memberInfo)
	{
		return getSqlSession().insert("member.insert", memberInfo);
	}
public MemberInfo modifyForm(String id){
		
		return getSqlSession().selectOne("member.modifyForm",id);
	}

}
