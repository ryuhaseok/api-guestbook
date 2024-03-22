package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//삭제
	@ResponseBody
	@RequestMapping(value="/api/guests{no}", method= {RequestMethod.DELETE})
	public int remove(@RequestBody GuestbookVo guestbookVo,
						@PathVariable(value="no") int no) {
		System.out.println("GuestbookController.remove()");
		guestbookVo.setNo(no);
		
		int count = guestbookService.exeRemove(guestbookVo);
		
		return count;
	}
	
	//등록+1개 가져오기
	@ResponseBody
	@RequestMapping(value="/api/guests", method= {RequestMethod.POST})
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		System.out.println(guestbookVo);
		
		GuestbookVo guestVo = guestbookService.exeAddandGuest(guestbookVo);
		System.out.println(guestVo);
		
		return guestVo;
	}
	

	//리스트
	@ResponseBody
	@RequestMapping(value="/api/guests", method= {RequestMethod.GET})
	public List<GuestbookVo> list() {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> guestbookList = guestbookService.exeGuestList();
		
		return guestbookList;
	}
	
}
