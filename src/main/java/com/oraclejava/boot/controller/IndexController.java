package com.oraclejava.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.boot.annotation.NoAuth;
import com.oraclejava.boot.dao.SingerPredicate;
import com.oraclejava.boot.dto.Singer;
import com.oraclejava.boot.service.SingerService;

@Controller
@RequestMapping(value="/index")
public class IndexController {

	@Autowired
	private SingerService singerService;
	
		@GetMapping
		@NoAuth
		public String list(@RequestParam (name="page", required = false) Integer page,
						   @RequestParam(name="search", required = false) String search,
						   Model model) {
			
			page = (page == null) ? 1 : page;

			int list = 5; // 페이지 당 데이터 수
			int block = 5; // 블록 당 페이지 수
			
			Pageable pageable = PageRequest.of(page, list);
			Page<Singer> singerList = 
					(search != null)? singerService.findAll(
							SingerPredicate.search(search), pageable) : 
					singerService.findAll(pageable);
			
			int current = singerList.getNumber() + 1;

			int nowBlock = (int)Math.ceil(page / (double)block);
			
			int begin = (nowBlock * block) - (block - 1);
			
			if(begin <= 1) {
				begin = 1;
			}
			
			int end = nowBlock * block;
			
			if(singerList.getTotalPages() <= end) {
				end = singerList.getTotalPages();
			}
			
			int blockNum = (int)Math.ceil(singerList.getTotalPages() / (double)block);
			
			model.addAttribute("singers",singerList);
			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			model.addAttribute("blockNum", blockNum);
			model.addAttribute("nowBlock", nowBlock);
			model.addAttribute("pageNum", singerList.getTotalPages());
			
			return "index";
		}
	
}
