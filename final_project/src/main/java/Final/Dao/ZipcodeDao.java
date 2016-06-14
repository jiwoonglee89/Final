package Final.Dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.Zipcode;

public class ZipcodeDao extends SqlSessionDaoSupport
{
	public List<ZipcodeDao> zipcodeSerach(String area4)
	{
		return getSqlSession().selectList("zipcode.zipcodeSerach",area4);
	}

}
