package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private Product entity;
	@Autowired
	private ProductRepository repo;
	
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	
	public String inItForm(Model model)
	{
		
		model.addAttribute("title","Add Products");
		model.addAttribute("command",entity);
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/product",method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("command")Product entity) {
		
		try {
			this.repo.add(entity);
				return "success";
			
			
		} catch (Exception e) {
			return "failure";
		}
	}
		
		@RequestMapping(value="/product/srch",method=RequestMethod.GET)
		public String inItSearchForm(Model model) {
			model.addAttribute("find","SearchProductById");
			return "searchproduct";
				
		}
		@RequestMapping(value="/product/srch",method=RequestMethod.POST)
		public String searchProduct(@RequestParam("id")int id,Model model) {
			Product entity= repo.findById(id);
			model.addAttribute("found", entity);
			return "showproduct";		
		}
		@RequestMapping(value="/product/delete",method=RequestMethod.GET)
		public String delete(Model model) {
			model.addAttribute("find","DeleteProductById");
			return "deleteproduct";
		}
		
		@RequestMapping(value="/product/delete",method=RequestMethod.POST)
			public String deletedProduct(@RequestParam("id")int id,Model model) {
				int entity=repo.remove(id);
				model.addAttribute("found", entity+" row is deleted");
				return "showproduct";		
			}
		@RequestMapping(value="/product/update",method=RequestMethod.GET)
		public String updateProduct(Model model) {
			
		
			model.addAttribute("title","Update Product");
			model.addAttribute("command",entity);

			return "updateproduct";
		}
		
		@RequestMapping(value="/product/update",method=RequestMethod.POST)
			public String showProduct(@ModelAttribute("id")Product id,Model model) {
				int entity=repo.update(id);
				model.addAttribute("found", entity+" row is updated");
				return "showproduct";		
			}
}


