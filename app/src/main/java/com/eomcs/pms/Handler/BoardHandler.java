package com.eomcs.pms.Handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;



public class BoardHandler {

  // 회원 정보를 저장할 메모리의 설계도
  // - 각 항목의 데이터를 저장할 변수를 선언한다.
  // - 이 변수를 "필드(field)"라고 부른다.
  //

  static final int LENGTH = 100;

  //개별적으로 관리해야 하는 값은 인스턴스 필드로 선언한다.
  Board[] boards = new Board[LENGTH];  // 레퍼런스 배열 준비  
  int size = 0;



  public  void add( ) {
    System.out.println("[게시글 등록]");

    Board b = new Board();

    b.no = Prompt.inputInt("번호? ");
    b.title = Prompt.inputString("제목? ");
    b.content = Prompt.inputString("내용? ");
    b.writer = Prompt.inputString("작성자? ");
    b.registeredDate = new Date(System.currentTimeMillis());

    this.boards[this.size++] = b;

    System.out.println("게시글을 등록하였습니다.");
  }

  public  void list( ) {
    System.out.println("[게시글 목록]");

    for (int i = 0; i < this.size; i++) {
      Board b = this.boards[i];
      // 번호, 제목, 등록일, 작성자, 조회수, 좋아요
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          b.no, 
          b.title, 
          b.registeredDate, 
          b.writer, 
          b.viewCount,
          b.like);
    }
  }


}
