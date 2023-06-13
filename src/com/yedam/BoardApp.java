package com.yedam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BoardApp extends Board {
	HashSet<Board> userList = new HashSet<>();
	BoardApp() {
		readFromFile();
	}
	
	List<Board> storage = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	public void register() {
		System.out.println("번호> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.println("제목> ");
		String title = scn.nextLine();
		System.out.println("내용> ");
		String content = scn.nextLine();
		System.out.println("작성자 > ");
		String name = scn.nextLine();

		storage.add(new Board(no, title, content, name));
	}

	public void modify() {
		System.out.println("번호> ");
		int no1 = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no1 == storage.get(i).getWriNo()) {
				System.out.println("변경내용을 적어주세요");
				storage.get(i).setContent(scn.nextLine());
			}
		}
		if (!isYn) {
			System.out.println("해당 번호가 없습니다.");
		}
	}

	public void search() {
		System.out.println("번호> ");
		int no1 = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no1 == storage.get(i).getWriNo()) {
				System.out.println(storage.get(i));
				isYn = true;
			}
		}
		if (!isYn) {
			System.out.println("해당 번호가 없습니다.");
		}
	}

	public void remove() {
		System.out.println("번호> ");
		int num = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getWriNo() == num) {
				storage.remove(i);
			}
		}
		if (!isYn) {
			System.out.println("해당 번호가 없습니다.");
		}
	}

	public void list() {
		for (int i = 0; i < storage.size(); i++) {
			System.out.println(storage.get(i));
//			System.out.printf("게시글번호 : , 제목 : , 내용: , 작성자", storage.get(i).getWriNo(), storage.get(i).getTitle(), storage.get(i).getContent(), storage.get(i).getName());
		}
	}



	public void readFromFile() {
		try {
			FileInputStream fir = new FileInputStream("c:/temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fir);
			
			storage = (List<Board>) ois.readObject();
			ois.close();
			fir.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void storeToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(storage);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
