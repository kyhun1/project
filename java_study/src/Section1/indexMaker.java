/// 출력 부분 에서 문제점 
// 소수점, 쉼표 등의 특수 기호가 단언에 포함된다. 
// 숫자 등이 단어로 취급된다. 
// 대문자와 소문자가 다른 단어로 취급된다. 
// 단어들이 알파벳 순으로 정렬 되면 좋겠다. 

package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class indexMaker {
	
	// 단어 목록에 저장된 길이 / 겹치는 개수 
//	static String [] words = new String [100000];
//	static int [] count = new int [100000]; // c에서는 정수 배열을 0으로 시작 할 경우가 다분 
	static Item [ ] items = new Item [100000] ; 
	static int n = 0;
	
	public static void main(String[] args) {

		Scanner kb = new Scanner (System.in);
		while ( true ) {
			
			System.out.print("$ ") ;
			String command = kb.next() ;
			if ( command.equals("read") ) {
				String fileName = kb.next();
				makeIndex( fileName ); 
			}
			
			else if ( command.equals("find") ) {
				String str = kb.next() ; 
				int index = findWord(str);
				if (index > -1 ) 
				{
					System.out.println("The word " + items[index].word + " appears " + items[index].count + " times. ");
				}
				else 
					System.out.println("The word " + str + " does not appear.");
			}
			
			else if ( command.equals("saves") ) 
			{ // 파일을 저장 하는 부분 
				 String fileName = kb.next() ;
				 saveAs ( fileName );
			}
			
			else if ( command.equals("exit") )
				break;
			
		}
		kb.close();
		
		for (int i = 0 ; i<n ; i++)
			System.out.println(items[i].word + " " + items[i].count) ;
	}
	
	static void saveAs( String fileName) { // 파일로 출력 하는 방법 
		//PrintWriter out = new PrintWriter( new PrintWriter (fileName)) ; // 이와 같이 작성하면 오류 처리에 대한 방안이 없어서 오류 메서지 
		PrintWriter outFile ; 
		try {
			outFile = new PrintWriter( new PrintWriter (fileName)) ;
			for ( int i=0; i<n; i++) 
				outFile.println(items[i].word + " " + items[i].count);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Save failed") ;
			return ; 
		}
	}
	
	static void makeIndex( String fileName) {
		
		try {
			Scanner inFile = new Scanner ( new File(fileName)) ;
			while ( inFile.hasNext()) { 
				String str = inFile.next(); 
				
				// trimmed 함수가 경우에 따라 null 생기는 경우에도 addWord 했기 때문에 에러
				// 발생해서 null일 경우에는 addWord 하지 말라는 코드를 추가 
				String trimmed = trimming(str);
				if (trimmed != null) {
					String t = trimmed.toLowerCase() ; // index 된 문자들을 소문자로 저장하고 싶을 떄 지정하는 코드 
					addWord( t );
				}
			}
			inFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file") ;
			return;
		}
	}
	
	// 단어의 앞뒤에 붙은 특수문자 제거하는 방법
	
	static String trimming(String str) {
		
		int i = 0, j= str.length()-1 ; 
		while( i < str.length() && !Character.isLetter ( str.charAt(i) ) )  // while i번쨰 변수가 문자가 아닐떄 까지 i번째 까지 증가 
			i++;																 // 알파벳이 없는 문자가 입력 들어오는 경우 판별을 못한다 ex: 23456^%%@ -> i <= str.length()
		
		while( j >= 0 && !Character.isLetter ( str.charAt(j) ) ) 			// 뒤에서 부터 확인을 하는 방법 
			j--; 
		
		// System.out.println(str + " : " + i + " : " + j) ; 
		// 오류 내용을 확인 하기 위해 println 구문을 이용하여 확인 하는 방법. 
		
		if (i > j )
			return null; 
		else 
			return str.substring( i, j+1 );
		// 위의 경우는 i와 j에서 문자열이 없어서 서로의 구간 값이 역전될 경우를 대비하여 작성한 코드 
		
		// substring = [ ) 이므로 i 에서 j+1 구간으로 지정을 해줘야 한다.
		
		
	}

	static void addWord (String str) {
		
		int index = findWord ( str ) ;	 
		
		if ( index != -1 ) { 			 // -1이면 이미 존재 한다.
			items[index].count ++;
		}
		else { 							// -1이 출력 되지 않으면 새로운 단어이다 
			int i = n-1 ;				// insert 하는 방법 -> 앞에서 부터 검사를 하면 모든 데이터를 확인 해야 하고 뒤에서 부터 확인 하면 앞에만 새로운 값을 넣어주면 되기 떄문에  
			while (i >=0 && items[i].word.compareTo(str) >0 ) {
//				items[i+1].word = items[i].word;
//				items[i+1].count = items[i].count;
				
				items[i+1] = items[i];
				i--;
			}
			
			items[i+1] = new Item() ;
			items[i+1].word = str ;
			items[i+1].count = 1; 				
			n++;
		}
	}
	
	static int findWord (String str) {
		for ( int i=0 ; i<n ; i++) 
			if ( items[i].word.equalsIgnoreCase((str)) )
				return i ; 
		return -1 ; // for 구문에서 str과 동일한 구문을 찾으면 출력이 되고 못찾으면 -1이 출력이 되어야 한다.
	}
}
// 정렬하는 방법 
// 1. 모든 단어를 index 후 정렬 하는 방법
// 2. 단어를 뽑아 냃때 마다 sort 해서 단어를 저장 하는 방법 