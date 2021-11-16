package com.projectfinal.stock.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class File {
	
	private int fileNum;
	private String originalFileName;
	private String savedFileName;
	private int articleNO;

}
