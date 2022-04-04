package com.example.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity  //엔티티 지정하고 게터세터
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

	
	@Id  //프라이머리키로 지정해주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //기본키 생성을 DB에 위임
	private long id;
	@Column
	private String title;
	@Column
	private String contents;
	@Column
	private LocalDateTime regDate;
	@Column
	private LocalDateTime updateTime;
	@Column
	private int hits;
	@Column
	private int likes;
	
}
