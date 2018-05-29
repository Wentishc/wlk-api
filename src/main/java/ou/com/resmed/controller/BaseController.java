package ou.com.resmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin
@Controller
@RequestMapping
public class BaseController {
	
	@RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
	
}
