package com.example.jpa.notice.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Notice;
import com.example.jpa.notice.exception.NoticeNotFoundException;
import com.example.jpa.notice.input.NoticeInput;
import com.example.jpa.notice.model.NoticeModel;
import com.example.jpa.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  //자동주입 어노테이션
@RestController
public class ApiNoticeController {
	
	private final NoticeRepository noticeRepository;
	

	/*
	 * @GetMapping("/api/notice") public String noticeSting() { return "notice"; }
	 */

	/*
	 * @GetMapping("/api/notice") public NoticeModel notice() {
	 * 
	 * LocalDateTime regDate = LocalDateTime.of(2022, 3, 24, 0, 0); NoticeModel
	 * notice = new NoticeModel(); notice.setId(1); notice.setTitle("공지사항입니다.");
	 * notice.setContents("내용입니다."); notice.setRegDate(regDate);
	 * 
	 * return notice;
	 */
/*
	@GetMapping("/api/notice")
	public List<NoticeModel> notice() {

		List<NoticeModel> noticeList = new ArrayList<>();

		NoticeModel notice1 = new NoticeModel();
		notice1.setId(1);
		notice1.setTitle("공지사항입니다.");
		notice1.setContents("내용입니다.");
		notice1.setRegDate(LocalDateTime.of(2022, 3, 24, 0, 0));

		noticeList.add(notice1);

		NoticeModel notice2 = NoticeModel.builder()
				.id(2)
				.title("두번째공지사항입니다")
				.contents("두번째내용입니다")
				.regDate(LocalDateTime.of(2022, 3, 25, 0, 0)).build();
		noticeList.add(notice2);

		return noticeList;
	}
	*/
	
//	@GetMapping("/api/notice")
//	public List<NoticeModel> notice() {
//		List<NoticeModel> noticeList = new ArrayList<>();
//		return noticeList;
//	}
//	
//	@GetMapping("/api/notice/count")
//	public int noticeCount() { return 10; }

	/*
	@PostMapping("/api/notice")
	public NoticeModel addNotice(@RequestParam String title, @RequestParam String contents) { 
		//파라미터 받은값
		NoticeModel notice = NoticeModel.builder()
				.id(1)
				.title(title)
				.contents(contents)
				.regDate(LocalDateTime.now())
				.build();
				
		return notice;
		
}
*/
/*	@PostMapping("/api/notice")
	public NoticeModel addNotice (NoticeModel noticeModel) {
		noticeModel.setId(2);
		noticeModel.setRegDate(LocalDateTime.now());
		
		return noticeModel;
	} */
	
	/*@PostMapping("/api/notice")
	public NoticeModel addNotice (@RequestBody NoticeModel noticeModel)  //json형태로 받기 위해 requestbody추가
	{
		noticeModel.setId(3);
		noticeModel.setRegDate(LocalDateTime.now());
		
		return noticeModel; */
	
	@PostMapping("/api/notice")
	public Notice addNotice (@RequestBody NoticeInput noticeInput) {
		
		Notice notice = Notice.builder()
				.title(noticeInput.getTitle())
				.contents(noticeInput.getContents())
				.regDate(LocalDateTime.now())
				.hits(0)
				.likes(0)
				.build();
		
		Notice resultNotice = noticeRepository.save(notice);
		return resultNotice;
//	}
//	
//	@GetMapping("/api/notice/{id}")  //id값을 받는다
//	public Notice notice(@PathVariable long id) {  //노티스 그대로 리턴하는 메서드/ 원래는 @RequestBody로 받았는데
//		//이번에는 주소로 받으니까 PathVariable
//		Optional<Notice> notice = noticeRepository.findById(id);
//		if (notice.isPresent()) {
//			return notice.get();
//		}
//		return null;
	}
	@ExceptionHandler(NoticeNotFoundException.class)
	public ResponseEntity<String> handlerNotFoundException(NoticeNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/api/notice/{id}")
	public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {//제목과 내용을 받는 noticeInput
		Optional<Notice> notice = noticeRepository.findById(id);
		if (!notice.isPresent())//예외발생
			{
			throw new NoticeNotFoundException("공지사항 글이 존재하지 않습ㄴ디ㅏ.");
			}
			notice.get().setTitle(noticeInput.getTitle());
			notice.get().setContents(noticeInput.getContents());
			notice.get().setUpdateTime(LocalDateTime.now());
			noticeRepository.save(notice.get());
	}//(정상)공지사항 글이 있을때- 저장을 한다.
	
	@PatchMapping("/api.notice/{id}/hits")
	public void noticeHits(@PathVariable Long id) {
		Notice notice = noticeRepository.findById(id)
				.orElseThrow(() -> new NoticeNotFoundException("글존재안함"));
		
		notice.setHits(notice.getHits() +1);
		noticeRepository.save(notice);
		
	}
	}

