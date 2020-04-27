package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.domain.Shoes;
import com.adminportal.service.ShoesService;


@Controller
@RequestMapping("/shoes")


public class ShoesController {
	
	@Autowired
	private ShoesService shoesService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addShoes(Model model) {
		Shoes shoes = new Shoes();
		model.addAttribute("shoes", shoes);
		return "addshoes";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addShoesPsot(
			@ModelAttribute("shoes") Shoes shoes, HttpServletRequest request
			) {
		shoesService.save(shoes);
		
		MultipartFile shoesImage = shoes.getShoesImage();
		
		try {
			byte[] bytes = shoesImage.getBytes();
			String name = shoes.getId()+".png";
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/imgs/shoes/"+name)));
			stream.write(bytes);
			stream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:shoesList";
	}
	
	@RequestMapping("/shoesList")
	public String shoesList(Model model) {
		List<Shoes> shoesList = shoesService.findAll();
		model.addAttribute("shoesList", shoesList);
		return "shoeslist";
	}
	
}
