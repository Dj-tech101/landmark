package UtilityxlUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class readExcel
 {
	
	
	String path ;
	String sheetName;
	
	
	public readExcel(String path,String sheetName) {
		
		this.path=path;
		this.sheetName=sheetName;
		
	}
	

	public static String[][] dataContainer(String path, String sheetname)
			throws EncryptedDocumentException, IOException {
		
		
		File f1= new File(path);
		

		FileInputStream file = new FileInputStream(f1);

		ReadxcelFile read = new ReadxcelFile(path, sheetname);

		int row = read.getrow();
		int col = read.getcoloumn();

		System.out.println("row " + row);
		System.out.println("coloum" + col);

		String[][] data = new String[row][col];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < col; j++) {

				data[i - 1][j] = read.getcellValue(i, j);
			}

		}
		return data;

	}
}