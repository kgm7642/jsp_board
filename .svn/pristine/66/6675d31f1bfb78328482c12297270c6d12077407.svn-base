package stream;
import java.io.*;

public class FileCopier {
	public static void main ( String[] args ) throws IOException {

		// 원본 파일 경로 : C:\\kgm\\file\\test.txt
		String originalpath = args[0];
		// 사본파일 경로 : C:\\kgm\\filecopy\\testcopy.txt
		String copypath = args[1];
		
		File originalfile = new File(originalpath); // 원래 파일
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(originalfile); //원래 파일을 IN
			os = new FileOutputStream(copypath); //복사 경로에 OUT
			
			int b = 0;
			// is.read() 메소드를 통해 1byte를 읽고 int 타입으로 리턴
			// 읽을 바이트가 없다면 -1 리턴
			while((b=is.read())!=-1) {
				os.write(b); //os에 is에서 읽은 정보들(b) 넣기
			}
			// 버퍼에 잔류하는 모든 바이트를 출력
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// 스트림을 닫아줌
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}