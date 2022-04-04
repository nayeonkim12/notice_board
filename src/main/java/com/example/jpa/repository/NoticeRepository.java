package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	  //어떤 키로 상속을 받는지
//pk가 long 타입
}
