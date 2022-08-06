package com.first.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.first.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void getListTest() {
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목1");
		board.setContent("테스트 내용입니다.");
		board.setWriter("user00");
		
		boardMapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목1 seleectkey");
		board.setContent("테스트 내용입니다.");
		board.setWriter("user00");
		
		boardMapper.insertSelectKey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = boardMapper.read(2L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		
		log.info("delete count : " + boardMapper.delete(2L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(3L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user02");
		
		int count = boardMapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
}
