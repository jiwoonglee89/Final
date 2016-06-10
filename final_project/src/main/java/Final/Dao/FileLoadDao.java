package Final.Dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import Final.Model.FileInfo;

public class FileLoadDao extends SqlSessionDaoSupport{

	public List<FileInfo> getList(String id){
		return getSqlSession().selectList("file.allById", id);
	}

	public int delete(String title) {
		return getSqlSession().delete("file.delete", title);
	}

	public FileInfo path(String title) {
		return getSqlSession().selectOne("file.selByTitle", title);
	}
}
