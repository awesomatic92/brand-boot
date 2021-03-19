package com.oraclejava.boot.controller;

import java.io.IOException;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oraclejava.boot.annotation.Authorize;
import com.oraclejava.boot.annotation.NoAuth;
import com.oraclejava.boot.dao.SingerPredicate;
import com.oraclejava.boot.dto.Singer;
import com.oraclejava.boot.service.SingerService;

@Controller
@RequestMapping(value = "/singers")
public class SingerController {
	
	private final Logger logger = LoggerFactory.getLogger(SingerController.class);
	
	@Autowired
	private SingerService singerService;
	
	// 가수 추가
	@GetMapping(value="/new")
	@Authorize(roles="C")
	public String createForm(Model model) {
		logger.info("가수 추가");
		Singer singer = new Singer();
		model.addAttribute("singer", singer);
		return "update";
	}
	
	// @RequestMapping(method=RequestMethod.GET)
	// Spring 5이상의 경우
	@GetMapping
	@NoAuth
	public String list(@RequestParam (name="page", required = false) Integer page,
					   @RequestParam(name="search", required = false) String search,
					   Model model) {
		logger.info("가수 목록 출력");
		page = (page == null) ? 1 : page;
		// 부하가 심함
		// System.out.println("가수....");
//		List<Singer> singerList = singerService.findAll();
//		model.addAttribute("singers", singerList);
//		logger.info("가수 수 : " + singerList.size());
		int list = 10; // 페이지 당 데이터 수
		int block = 10; // 블록 당 페이지 수
		
		Pageable pageable = PageRequest.of(page, list);
		Page<Singer> singerList = 
				(search != null)? singerService.findAll(
						SingerPredicate.search(search), pageable) : 
				singerService.findAll(pageable);
		
		int current = singerList.getNumber() + 1;
		// int begin = 1;
		// int end = singerList.getTotalPages();
		
		// 현재 페이지가 위치한 블록번호
		int nowBlock = (int)Math.ceil(page / (double)block);
		
		// 시작 페이지
		int begin = (nowBlock * block) - (block - 1);
		
		if(begin <= 1) {
			begin = 1;
		}
		
		// 마지막 페이지
		int end = nowBlock * block;
		
		if(singerList.getTotalPages() <= end) {
			// 마지막 블록이 애매하게 끝난 경우 마지막 변수(end)에 전체 페이지 수를 대입해 준다.
			end = singerList.getTotalPages();
		}
		
		// 총 블록 계산
		int blockNum = (int)Math.ceil(singerList.getTotalPages() / (double)block);
		
		model.addAttribute("singers",singerList);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("blockNum", blockNum);
		model.addAttribute("nowBlock", nowBlock);
		model.addAttribute("pageNum", singerList.getTotalPages());
		
		logger.info("가수 수 : " + singerList.getSize());
		logger.info("beginIndex: " + begin);
		logger.info("endIndex: " + end);
		logger.info("currentIndex: " + current);
		logger.info("blockNum: " + blockNum);
		logger.info("nowBlock: " + nowBlock);
		logger.info("pageNum: " + singerList.getTotalPages());
		return "singers";
	}
	
	@GetMapping(value = "/{id}")
	@NoAuth
		public String getSinger(@PathVariable("id") Integer id, Model model) {
		logger.info("가수 상세 출력");
		Singer singer = singerService.findOne(id);
		model.addAttribute("singer", singer);
		logger.info(singer.toString());
		return "show";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("가수 수정 출력");
		Singer singer = singerService.findOne(id);
		model.addAttribute("singer", singer);
		logger.info(singer.toString());
		return "update";
	}
	
	@PostMapping(params="update")
	public String saveSinger(@RequestParam("photo2") MultipartFile file, @Valid Singer singer) throws IOException {
		logger.info("가수 수정 실행");
		Singer oldSinger = null;
		if (singer.getId() != null) {
			oldSinger = singerService.findOne(singer.getId());
		}else {
			oldSinger = new Singer();
		}
		
		if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()) {
			logger.debug("업로드한 파일이 있음");
			byte[] bArr = file.getBytes();
			oldSinger.setPhoto(bArr);
		}
		
		oldSinger.setFirstName(singer.getFirstName());
		oldSinger.setLastName(singer.getLastName());
		oldSinger.setDescription(singer.getDescription());
		oldSinger.setBirthDate(singer.getBirthDate());

		
		singerService.save(oldSinger);
		return "redirect:/singers";
	}
	
	// 삭제 기능구현
	@PostMapping(params="delete")
	@Authorize(roles="C")
	public String removeSinger(@Valid Singer singer) {
		logger.info("가수 삭제(단일)");
		singerService.delete(singer.getId());
		return "redirect:/singers";
	}
	
	// 선택 삭제 기능 구현
	@PostMapping(value="/delete")
	@Authorize(roles="C")
	public String delete(@RequestParam(name="sid", required=false) Set<Integer> sid, Model model) {
		logger.info("가수 삭제(복수)");
		singerService.deleteAll(sid);
		
		return "redirect:/singers";
	}
	
	
	@RequestMapping(value="/photo/{id}", method=RequestMethod.GET)
	@ResponseBody
	@NoAuth
	public byte[] downloadFile(@PathVariable("id")
						Integer id) {
		logger.info("사진 다운로드");
		Singer singer = singerService.findOne(id);
		return singer.getPhoto();
		
	}
				
	
	
}
