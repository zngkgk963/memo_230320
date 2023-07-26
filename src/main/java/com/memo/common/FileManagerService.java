package com.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // 일반적인 spring bean
public class FileManagerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 실제 업로드가 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "D:\\parkjaehyun\\6_spring_project\\memo\\workspace\\images/";
	
	// input: MultipartFile(이미지 파일), loginId
	// output: web image path(String)
	public String saveFile(String loginId, MultipartFile file) {
		// 파일 디렉토리(폴더)	예) aaaa_1673242/sun.png
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/"; //aaaa_1673242
		String filePath = FILE_UPLOAD_PATH + directoryName; //D:\\parkjaehyun\\6_spring_project\\memo\\workspace\\images/aaaa_1673242
		
		// 폴더 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 만드는데 실패 시 이미지 경로 null로 리턴
			return null;
		}
		
		// 파일 업로드: byte 단위 업로드
		try {
			byte[] bytes = file.getBytes();
			// *** 한글 이름 이미지는 올릴 수 없으므로 나중에 영문자로 바꿔서 올리기
			Path path = Paths.get(filePath + file.getOriginalFilename()); // 디렉토리 경로 + 사용자가 올린 파일명
			Files.write(path, bytes); // 파일 업로드
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; // 이미지 업로드 실패 시 null 리턴
		}
		
		// 파일업로드가 성공했으면 웹 이미지 url path를 리턴한다.
		// /images/aaaa_1689839340603/스크린샷(1).png
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	// 파일 삭제 메소드
	// input: imagePath
	// output: void
	public void deleteFile(String imagePath) { // imagePath /images/aaaa_1689843619477/dfs.png
		// FILE_UPLOAD_PATH + D:\\parkjaehyun\\6_spring_project\\memo\\workspace\\images//images/aaaa_1689843619477/dfs.png
		// 주소에 겹치는 /images/ 를 제거한다.
		
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));
		if (Files.exists(path)) { // 이미지가 존재하는가?
			// 이미지 삭제
			try {
				Files.delete(path);
			} catch (IOException e) {
				logger.info("###[FileManagerService 이미지 삭제 실패] imagePath:{}", imagePath);
			}
			
			// 디렉토리(폴더) 삭제
			path = path.getParent();
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.info("###[FileManagerService 이미지 폴더 삭제 실패] imagePath:{}", imagePath);
					return;
				}
			}
		}
	}
}
