package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.ForSemeter;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrentAll();
		
		ForSemeter fs161 = new ForSemeter(), fs162 = new ForSemeter(), 
				fs171 = new ForSemeter(), fs172 = new ForSemeter(), 
				fs181 = new ForSemeter(), fs182 = new ForSemeter();
		fs161.setYear(2016); fs161.setSemester(1); fs161.setTotalGrade(0);
		fs162.setYear(2016); fs162.setSemester(2); fs162.setTotalGrade(0);
		fs171.setYear(2017); fs171.setSemester(1); fs171.setTotalGrade(0);
		fs172.setYear(2017); fs172.setSemester(2); fs172.setTotalGrade(0);
		fs181.setYear(2018); fs181.setSemester(1); fs181.setTotalGrade(0);
		fs182.setYear(2018); fs182.setSemester(2); fs182.setTotalGrade(0);
		
		for(Offer o : offers) {
			if(o.getYear() == 2016 && o.getSemester() == 1) {
				fs161.setTotalGrade(fs161.getTotalGrade() + o.getGrade());
			}
			if(o.getYear() == 2016 && o.getSemester() == 2) {
				fs162.setTotalGrade(fs162.getTotalGrade() + o.getGrade());
			}
			if(o.getYear() == 2017 && o.getSemester() == 1) {
				fs171.setTotalGrade(fs171.getTotalGrade() + o.getGrade());
			}
			if(o.getYear() == 2017 && o.getSemester() == 2) {
				fs172.setTotalGrade(fs172.getTotalGrade() + o.getGrade());
			}
			if(o.getYear() == 2018 && o.getSemester() == 1) {
				fs181.setTotalGrade(fs181.getTotalGrade() + o.getGrade());
			}
			if(o.getYear() == 2018 && o.getSemester() == 2) {
				fs182.setTotalGrade(fs182.getTotalGrade() + o.getGrade());
			}
		}
		
		model.addAttribute("fs161", fs161);
		model.addAttribute("fs162", fs162);
		model.addAttribute("fs171", fs171);
		model.addAttribute("fs172", fs172);
		model.addAttribute("fs181", fs181);
		model.addAttribute("fs182", fs182);
		
		return "offers";
	}
	
	@RequestMapping("/semester")
	public String showSemester(@RequestParam("year") String year, 
			@RequestParam("semester") String semester, Model model) {
		
		int yearInt = Integer.parseInt(year);
		int semesterInt = Integer.parseInt(semester);
		
		List<Offer> offers = offerService.getCurrent(yearInt, semesterInt);
		
		model.addAttribute("offers", offers);
		
		return "semester";
	}
	
	
	@RequestMapping("/createoffer")
	public String createOffers(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	
	@RequestMapping(value="/docreate", produces="text/html; charset=utf-8")
	public String docreate(Model model, @Valid Offer offer, BindingResult result) {
		
		System.out.println(offer.getCoursename());
		
		if(result.hasErrors()) {
			System.out.println("===Form data dose not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated";
	}
}
