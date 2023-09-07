package com.care.root.ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.Ser.MService;
import com.care.root.dto.MDto;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired MService ms;
	
	public MController() {
		System.out.println("ctrl ¿¬µ¿");
	}
	
	@GetMapping("main")
	public String main() {
		return "member/main";
	}
	
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(MDto dto) {
		System.out.println("ctrl dto: "+ dto.getId());
		ms.register(dto);
		return "member/login";
	}

	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("login_chk")
	public String loginChk(@RequestParam String id,
			@RequestParam String pwd,
			HttpSession session) {
		
		int result = ms.loginChk(id, pwd);
		
		if (result == 1) {
			session.setAttribute("id", id);
			return "redirect:main";
		}
		return "redirect:login";
	}
	
	
	@GetMapping("list")
	public String list(Model model) {
		System.out.println("ctrl list");
		
		ArrayList<MDto> dto = ms.list();
		model.addAttribute("list", dto);
		return "member/list";
	}
	
	@GetMapping("info")
	public String info(@RequestParam String id, Model model) {
		System.out.println("ctrl info : "+ id);
		
		MDto dto = ms.getInfo(id);
		model.addAttribute("dto", dto);
		return "member/info";
	}
}
