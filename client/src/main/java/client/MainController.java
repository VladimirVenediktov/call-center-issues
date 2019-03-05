package client;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
	
	//запросы курьера
	@PostMapping("/new")
    public String addPostponedIssue(@RequestParam(value="number") int number, Map <String, Object> model) {
		
		RestTemplate restTemplate = new RestTemplate();
        String answer = restTemplate.getForObject("http://localhost:9000/add?number="+number, String.class);
        model.put("answer", answer);
        return "newissue";
        
    }
	
	//запросы оператора
	@GetMapping("/issues")
    public String getOrdersList (Map <String, Object> model) {

		RestTemplate restTemplate = new RestTemplate();
        Issue[] issues = restTemplate.getForObject("http://localhost:9000/postponed", Issue[].class);
        model.put("issuesList", issues);
        return "issues";
    }
	
	@GetMapping("/filter")
    public String findIssueByNumOrder (@RequestParam(value="number") int number, Map <String, Object> model) {

		RestTemplate restTemplate = new RestTemplate();
        Issue[] issues = restTemplate.getForObject("http://localhost:9000/postponed", Issue[].class);
        for (int i=0; i<issues.length; i++) {
        	if (issues[i].getNumber()==number) {
        		model.put("issue", issues[i]);
        	}
        }
        return "filter";
    }
	
	
    
}
