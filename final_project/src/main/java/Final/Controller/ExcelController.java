package Final.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExcelController {
	
	@RequestMapping
	public String form(){
		return "excel";
	}

}
