package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.form.IndexForm;
import com.example.demo.entity.Product;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("index") IndexForm form, Model model) {
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(101, "鉛筆", 50));
		productList.add(new Product(102, "消しゴム", 100));
		
		model.addAttribute("productList", productList);
		
		return"index";
	}
	
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute("index") IndexForm form, Model model) {
		String name = form.getName();
		int id = form.getId();
		
		Product product = null;
		switch(id) {
			case 101:
				product = new Product(101, "鉛筆", 50);
				break;
			case 102:
				product = new Product(102, "消しゴム", 100);
				break;
		}
		
		model.addAttribute("product", product);
		model.addAttribute("name", form.getName() + "さんが下記の商品を選択しました");
		return "result";
	}
}
