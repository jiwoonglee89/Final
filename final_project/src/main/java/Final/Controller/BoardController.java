package Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Final.Dao.FileLoadDao;
import Final.Dao.MemberDao;

@Controller
public class BoardController {

	
	private FileLoadDao fileLoadDao;
	private MemberDao memberDao;

	@Autowired
	public void setFileLoadDao(FileLoadDao fileLoadDao) {
		this.fileLoadDao = fileLoadDao;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
}
