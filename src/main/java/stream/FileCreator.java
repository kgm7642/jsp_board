package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {
    public static void main(String[] args) {        
    	try {            
    		// 1. 파일 객체 생성
    		// 파일 경로 args[0] : C:\\kgm\\file\\writeFile.txt
    		File file = new File(args[0]);             
    		// 2. 파일 존재여부 체크 및 생성            
    		if (!file.exists()) {            
    			file.createNewFile();      
    		}             
    		// 3. Writer 생성
    		FileWriter fw = new FileWriter(file);            
    		PrintWriter writer = new PrintWriter(fw);             
    		// 4. 파일에 쓰기 args[1] : "안녕하세요!!!"
    		writer.write(args[1]);                        
    		// 5. PrintWriter 닫기
    		writer.close(); 
    		} catch (IOException e) {            
    			e.printStackTrace();       
    		}
    }
}
