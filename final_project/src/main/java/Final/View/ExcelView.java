package Final.View;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.*;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.springframework.stereotype.Component;
//import org.apache.poi.hssf.record.FormulaRecord;
import org.springframework.web.servlet.view.document.AbstractXlsView;

@Component("uploadExcelView")
public class ExcelView extends AbstractXlsView implements FreeRefFunction{
	

	@SuppressWarnings("resource")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,	
			HttpServletResponse response) throws Exception {
		FunctionEval.getBasicFunction(0);
		FunctionEval.getSupportedFunctionNames();
		//Cell sumcell;
		//sumcell.setCellFormula("SUM(C3:");
		
		
		//여기서 부터 파일 읽기
		FileInputStream fis = (FileInputStream) model.get("fis");

		workbook = new HSSFWorkbook(fis);
		
		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 0; rowindex < rows; rowindex++) {
			Row row = sheet.getRow(rowindex);
			if (row != null) {
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					Cell cell = row.getCell(columnindex);
					String value = "";
					if (cell == null) {
						value="";
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
					System.out.println("각 셀 내용 :" + value);

				}
			}
		}
	}

	public ValueEval evaluate(ValueEval[] arg0, OperationEvaluationContext arg1) {
		
		//double arg=Operandk
				
				
				
		return null;
	}	
	
	

}
