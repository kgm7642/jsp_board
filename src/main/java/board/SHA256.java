package board;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 유저 비밀번호 암호화를 위한 클래스
public class SHA256 {

	// 클래스 내부에 고정된 소금 값(해시 함수에 추가되어 보안을 강화해주는 역할)을 저장
	private final static String mSalt = "abc";
	
	// 문자열을 입력 받아 SHA-256 해시로 변환한 결과를 반환
	public static String encodeSha256(String source) {
		
		// 결과 문자열
		String result = "";
		
		// 입력 받은 문자열을 바이트 배열로 변환
		byte[] a = source.getBytes();
		
		//소금 값을 바이트 배열로 변환
		byte[] salt = mSalt.getBytes();
		
		// 원래 문자열의 바이트 배열과 소금의 바이트 배열을 합친 배열을 저장할 새로운 바이트 배열 생성
		byte[] bytes = new byte[a.length + salt.length];
		
		// 원래 문자열의 바이트 배열에 복사
		System.arraycopy(a, 0, bytes, 0, a.length);
		
		// 소금 바이트를 새로운 배열에 추가
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			// 해시 함수를 사용하기 위해 "MessageDigest" 객체 생성
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			// 입력 데이터를 해시 함수에 전달
			md.update(bytes);
		
			// 해시 함수를 사용하여 입력 데이터의 해시 값을 계산
			byte[] byteData = md.digest();
			
			// 결과를 저장할 StringBuffer 객체를 생성
			StringBuffer sb = new StringBuffer();
			
			// 해시값의 각 바이트를 순회하며 16진수로 변환 후 StringBuffer에 추가
			for (int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			
			// StringBuffer의 값을 문자열로 변환
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
