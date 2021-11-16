package com.projectfinal.stock.common;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaverHelper {
	@Resource(name="saveDir") //@리소스는 이름으로 찾아서 DI해줌
	private String saveDir;
	
	@Bean
	public String saveDir() {
	  	 return new String("d:/upload/");
	     }
	
	public String save(MultipartFile uploadFile) {
		String savedFileName=UUID.randomUUID().toString()+"_"+uploadFile.getOriginalFilename();
		try {
			uploadFile.transferTo(new File(saveDir+savedFileName));
		}catch(Exception e) {}
		
		return savedFileName;
	}
}

