package com.yedam;

import java.util.Scanner;

public class BorderMain {
	public static void main(String[] args) {
		
		
		
		
		Scanner scn = new Scanner(System.in);
		BoardApp app = new BoardApp();
		
		
		boolean run = true;
		while(run) {
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록 6.종료");
			System.out.println("선택 > ");
			int num = Integer.parseInt(scn.nextLine());
			
			switch(num) {
			case 1:
				app.register();
				break;
			case 2:
				app.modify();
				break;
			case 3:
				app.search();
				break;
			case 4:
				app.remove();
				break;
			case 5:
				app.list();
				break;
			case 6:
				app.storeToFile();
				return;
			}
		}
		System.out.println("끝~~");
	}
}
