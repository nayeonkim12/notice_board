package com.example.jpa.notice.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //전체생성자를 만들어주는
@NoArgsConstructor  //디폴트 생성자 만들어주는
@Builder  //빌더 패턴
@Data  //롬복의 data가 게터세터 자동 생성해줌
public class NoticeModel {

	//id 제목 내용 등록일(작성일) 4가지
	
	private int id;
	private String title;
	private String contents;
	private LocalDateTime regDate;
}
