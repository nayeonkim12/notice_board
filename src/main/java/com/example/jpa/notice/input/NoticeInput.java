package com.example.jpa.notice.input;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor  
@Builder  
@Data  
public class NoticeInput {

	private String title;
	private String contents;
	//noticeInput에 관해서는 두 가지만 있으면 됩니다.
}
