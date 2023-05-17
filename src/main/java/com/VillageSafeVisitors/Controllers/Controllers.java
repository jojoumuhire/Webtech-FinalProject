package com.VillageSafeVisitors.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.VillageSafeVisitors.Models.Models;
import com.VillageSafeVisitors.Models.SignUp;
import com.VillageSafeVisitors.Repositorys.Repositorys;
import com.VillageSafeVisitors.Repositorys.SignUpRepo;
import com.VillageSafeVisitors.Services.Save;

@Controller
public class Controllers {

	@Autowired
	private Save services; 
	@Autowired
	private SignUpRepo signuprepo;
	@Autowired
	private Repositorys repositorys;
	@RequestMapping("/")
	public String home() {
	
		return "SignUpuser";
}
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	@RequestMapping("/save")
	public String createvisitor(@RequestParam("names") String names,@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("currentVillage") String currentVillage,@RequestParam("newVillage") String newVillage)
			{
		 Models Visitor=new Models();
		
		Visitor.setNames(names);
		Visitor.setEmail(email);
		Visitor.setPhone(phone);
		Visitor.setCurrentVillage(currentVillage);
		Visitor.setNewVillage(newVillage);
		
		services.saveVisitor(Visitor);
		
		
		return "redirect:/view";
		
			}
	@GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id) {
        
        Optional<Models> user = repositorys.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Update");
        mav.addObject("allusers",user);

        return mav;
    }
	@RequestMapping("/view")
    public  ModelAndView homeafter(){
        
		return PageShow(1);
	}
	@PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id,Models user) {
        Models userAttributes=new Models();
        userAttributes.setId(user.getId());
        userAttributes.setNames(user.getNames());
        userAttributes.setEmail(user.getEmail());
        userAttributes.setPhone(user.getPhone());
        userAttributes.setCurrentVillage(user.getCurrentVillage());
        userAttributes.setNewVillage(user.getNewVillage());
        Models updatedUser = services.updateUser(userAttributes);
        
        
        return "redirect:/view";
	}
	@GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        Models user = repositorys.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repositorys.delete(user);
        return "redirect:/view";
    }
	
	@RequestMapping("/account")
	  public String createAccount (@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirmpassword") String confirmpassword) {
		
	SignUp visitor=new SignUp();
	
	visitor.setEmail(email);
	visitor.setPassowrd(password);
	visitor.setConfirmPassowrd(confirmpassword);
	services.createAccount(visitor);
		return "index";
	}
	@RequestMapping("/indexaction")
	public String createAccount(@RequestParam("email") String email, @RequestParam("password") String password) {
	SignUp user = null;
	
	try {
		user = signuprepo.findByEmail(email);
		
				
	}catch (Exception e) {
		System.out.println(e);
	}
	if(user!=null &&(user.getEmail().equals(email)&& user.getPassowrd().equals(password))) {
		return "VisitorsForm";

		}else{
			return "index";
		}
}
	@GetMapping("/page/{pageNo}")
    public  ModelAndView PageShow(@PathVariable (value = "pageNo") int pageNo){
        ModelAndView mav=new ModelAndView();
        int pageSize=5;
        Page<Models> page=services.getPaginated(pageNo,pageSize);
        List<Models> allusersdata=page.getContent();
        mav.setViewName("Read");
        mav.addObject("currentPage",pageNo);
        mav.addObject("totalPages",page.getTotalPages());
        mav.addObject("totalItems",page.getTotalElements());
        mav.addObject("displayAll",allusersdata);
        return  mav;
    }
}
