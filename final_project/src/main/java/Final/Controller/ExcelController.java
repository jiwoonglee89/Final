package Final.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Final.Dao.FileLoadDao;
import Final.Dao.MemberDao;
import Final.Model.FileInfo;

@Controller
public class ExcelController {
	@Autowired
	private FileLoadDao fileLoadDao;

	public void setFileLoadDao(FileLoadDao fileLoadDao) {
		this.fileLoadDao = fileLoadDao;
	}

	@RequestMapping("/newExcel.do")
	public String form() {
		return "NewFile";
	}

	@RequestMapping("/existExcel.do")
	public ModelAndView existExcel(String title) throws FileNotFoundException {

		
		FileInputStream fis = new FileInputStream("C:/Users/wonmo/Desktop/123.xls");

		return new ModelAndView("uploadExcelView", "fis", fis);
	}
	
	/*@RequestMapping("/existExcel.do")
	public ModelAndView existExcel(String title) throws FileNotFoundException {

		FileInfo fileInfo = fileLoadDao.path(title);
		String path = fileInfo.getPath();
		FileInputStream fis = null;

		if (fileInfo != null) {

			fis = new FileInputStream(path);
		}

		return new ModelAndView("uploadExcelView", "fis", fis);
	}*/

}
