package Final.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Final.Dao.FileLoadDao;

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

	/*
	 * @RequestMapping("/existExcel.do") public ModelAndView existExcel(String
	 * title) throws FileNotFoundException {
	 * 
	 * File file = new File("C:/Users/wonmo/Desktop/123.xls");
	 * 
	 * return new ModelAndView("uploadExcelView", "file", file); }
	 */

	// 기존엑셀파일 불러오기
	@SuppressWarnings("resource")
	@RequestMapping("/existExcel.do")
	public String existExcel(HttpServletRequest request) throws IOException {

		Map map = new HashMap();
		Workbook workbook = null;

		File file = new File("C:/Users/wonmo/Desktop/123.xls");
		FileInputStream fis = new FileInputStream(file);
		System.out.println("파일형식::::" + file.getName().endsWith("xls"));
		if (file.getName().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		} else {
			workbook = new XSSFWorkbook(fis);
		}

		String cellName = "";
		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int colNum = 0;

		for (rowindex = 0; rowindex < rows; rowindex++) {
			Row row = sheet.getRow(rowindex);

			colNum = colNum + 1;

			if (row != null) {
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					Cell cell = row.getCell(columnindex);

					char rowrowrow = (char) (65 + columnindex);

					System.out.println("rows:::" + rowrowrow + "cells:::" + colNum);
					System.out.println(rowrowrow + "" + colNum);
					cellName = rowrowrow + "" + colNum;

					String value = "";
					if (cell == null) {
						value = " ";
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case Cell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case Cell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case Cell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}

					}
					System.out.println("cellName:::" + cellName);
					map.put(cellName, value);
					request.setAttribute("map", map);

					System.out.println("셀 내용 :" + value);
					// cell 은 값
				}

			}
		}
		return "test";
	}

	// 삭제 ㄴㄴ
	/*
	 * @RequestMapping("/existExcel.do") public ModelAndView existExcel(String
	 * title) throws FileNotFoundException {
	 * 
	 * FileInfo fileInfo = fileLoadDao.path(title); String path =
	 * fileInfo.getPath(); FileInputStream fis = null;
	 * 
	 * if (fileInfo != null) {
	 * 
	 * fis = new FileInputStream(path); }
	 * 
	 * return new ModelAndView("uploadExcelView", "fis", fis); }
	 */

	
	
	@RequestMapping("/readTxt.do")
	public ModelAndView readTxtFile(String path) {

		ModelAndView mav = new ModelAndView("test");
		
		
		File file = new File("C:/Users/wonmo/Desktop/123.txt");
		
		try {
			String value = null;
			char i = 64;
			int j =1;
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			List list = new ArrayList();
			list.add(br.read());
			System.out.println("list.size()::"+list.size());
			for (int colLine = 0; colLine < list.size(); colLine++) {
				if (br.readLine() != null) {
					value= br.readLine();
					i = (char)(i+1);
				}/*if else (br.readLine()!= -1 || ){
					j = j+1;
				}*/
				String colName = i+""+j;
				
				Map map = new HashMap();
				map.put(colName, value);
				
				System.out.println(colName);
				System.out.println(value);
				

				mav.addObject("map", map);
			}
		} catch (Exception e){
			e.printStackTrace();
		}

		return mav;
	}
}