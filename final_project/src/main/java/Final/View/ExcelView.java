package Final.View;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.*;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

//import org.apache.poi.hssf.record.FormulaRecord;
import org.springframework.web.servlet.view.document.AbstractXlsView;


public class ExcelView extends AbstractXlsView implements FreeRefFunction{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,	
			HttpServletResponse response) throws Exception {
		FunctionEval.getBasicFunction(0);
		FunctionEval.getSupportedFunctionNames();
		//Cell sumcell;
		//sumcell.setCellFormula("SUM(C3:");
	}

	public ValueEval evaluate(ValueEval[] arg0, OperationEvaluationContext arg1) {
		
		//double arg=Operandk
				
				
				
		return null;
	}	

}
