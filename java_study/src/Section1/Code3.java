package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code3 {

	static Person1[] members = new Person1 [100] ; 
	static int n = 0;
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner (new File ("input.txt") ) ;
			while ( in.hasNext() ) {
				String nm = in.next();
				String nb = in.next();
				
				// members = 참조 변수 
				members[n] = new Person1() ; 
				members[n].name = nm;
				members[n].number = nb;
				n++ ;
 			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file");
		}
		
		bubbleSort( );
		
		for (int i=0 ; i < n ; i++) 
			System.out.println(members[i].name + " " + members[i].number);
		
	}

	private static void bubbleSort() {

		for (int i=n-1 ; i>0; i--) {
			for (int j=0; j<i; j++) {
				if ( members[j].name.compareTo(members[j+1].name) > 0 ) { // compare names of j-th and (j+1)-th pesron
					//swap two persons
					// non-private 함수는 참조 변수
					Person1 tmp = members[j] ;
					members[j] = members[j+1];
					members[j+1] = tmp;
					// 클래스, 참조변수, 객체에 대한 이론 C에는 존재하지 않는 변수
					// class : 타입이다. => 설계도 / 클래스 자체의 변수를 읽는 다는것은 잘못된 말 -> 설게도를 이용한 객체 선언일 뿐이다. 
					// 참조변수, 객체 -> 실체 
					// ex) Person a = new Person () -> a : 참조변수 / new 이후 선언된 것은 객체. 객체는 new로만 만들어 지기 떄문에 고유한 이릉믕 가질 수 없다. 
					// 객체를 이용할 수 있게 보관할 수 있게 만드는 변수를 참조 변수 / 참조변수 안에는 객체 안에 있는 정보의 주소를 담고 있는 변수 
					// 객체 : new 이후로 선언된 변수로써 각각의 정보를 사용할 수 없다 <-> 참조변수 : 객체 자체로 사용할 수 없기 떄문에 이에 관련된 객체들의 주소를 참조 하여 사용할 수 있게 만드는 변수
					// C에서 포인터가 존재 하는데 자바의 객체와 동일한 형태  
 				}
			}
		}
	}
}

// 인덱스 메이커 프로그램 
// 하나의 단어와 그 단어의 등장 빈도를 저장하기 위한 클래스 
// 

