package Final.Dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.Zipcode;

public class ZipcodeDao extends SqlSessionDaoSupport
{
	public List zipcodeSerach(Zipcode zipCode)
	{
		return getSqlSession().selectList("zipcode.zipcodeSerach",zipCode);
	}

}
