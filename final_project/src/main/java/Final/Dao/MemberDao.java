package Final.Dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.MemberInfo;

public class MemberDao extends SqlSessionDaoSupport{

	//���̵� ������ ȸ������ ���� ��������
	public MemberInfo getMember(String id){
		return getSqlSession().selectOne("member.one", id);
	}

	public int modify(MemberInfo memberInfo) {
		return getSqlSession().update("member.modify",memberInfo);
	}
}
