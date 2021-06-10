package co.board.access;

import java.util.Scanner;

import co.board.model.Board;
import co.board.view.CommentApp;

public class BDAOExecutor{
	static Scanner scanner = new Scanner(System.in);
	static BoardDAO bdao = new BoardDAO();
	static CommentDAO cdao = new CommentDAO();

	public static void getAllPost() {
		for (Board b : bdao.getAllPosts()) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%d.| 제목: %s | 작성자: %s\n",b.getB_id(), b.getB_title(), b.getB_writer());
		}
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public static void getPost() {
		try {
			System.out.print("조회할 글 번호>");
			int id = scanner.nextInt();
			Board result = bdao.getPost(id);
			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%d.| 제목: %s | 작성자: %s\n",result.getB_id(), result.getB_title(), result.getB_writer());
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(" "+result.getB_content());
			System.out.println("-----------------------------------------------------------------------------");
			
			CommentApp.start(id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertPost() {
		try {
			Board board = new Board();
			System.out.print("제목(띄워쓰지마세요)>");
			String title = scanner.next();
			System.out.print("작성자>"); scanner.nextLine();
			String writer = scanner.nextLine();
			System.out.print("내용>"); 
			String content = scanner.nextLine();
			
			board.setB_title(title);
			board.setB_writer(writer);
			board.setB_content(content);
			
			bdao.insertPost(board);
			
			System.out.println("작성완료");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updatePost() {
		try {
			System.out.print("수정할 글 번호>");
			int id = scanner.nextInt();
			System.out.print("수정할 내용>"); scanner.nextLine();
			String content = scanner.nextLine();
			
			bdao.updatePost(id, content);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deletePost() {
		try {
			System.out.print("삭제할 글 번호>");
			int id = scanner.nextInt();
			
			bdao.deletPost(id);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
