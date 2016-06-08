package Final.Dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.MemberInfo;

public class MemberDao extends SqlSessionDaoSupport{

	//아이디 값으로 회원정보 한줄 가져오기
	public MemberInfo getMember(String id){
		return getSqlSession().selectOne("member.one", id);
	}

	public int modify(MemberInfo memberInfo) {
		return getSqlSession().update("member.modify",memberInfo);
	}
}
