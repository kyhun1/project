package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {

	// 자료 구조 변수를 만드는것이 우선 
	static MyRectangle2 [ ] rects = new MyRectangle2 [100]; // rects 배열의 주소를 받아주는 객체 이기에 rects 지정 필요 
	static int n = 0; 

	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(new File ("data.txt"));
			while(in.hasNext()){
//				int x = in.nextInt();
//				int y = in.nextInt();
//				int w = in.nextInt();
//				int h = in.nextInt();
//				rects[n] = new MyRectangle2(x,y,w,h);
				// 기본적인 틀은 위와 같지만 줄 수를 줄이기 위해서는 아래와 같은 방법을 사용해도 문재는 없다 
				rects[n] = new MyRectangle2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
				n++;
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("No data flie.");
			System.exit(1);
		}
		
		bubbleSort() ; 
		
		for (int i = 0 ; i< n ; i++)
			System.out.println( rects[i].toString() );
	}

	private static void bubbleSort() {
		for (int i=n-1 ; i>0 ; i-- ) {
			for (int j = 0 ; j<i ; j++) {
				//swap 하기위해 객체를 생성하여 변환 시키는 부분을 지정 
				if ( rects[j].calcArea() > rects[j+1].calcArea() ) {
					MyRectangle2 tmp = rects[j] ;
					rects[j] = rects[j+1] ;
					rects[j+1] = tmp;
				}
			}
		}
	}
}

// code 05와의 차이점 
// 추가적인 변수들이 들어왔을 떄 각각의 클래스에서 변수를 추가 및 수정을 해줘야 하지만 
// 현재와 같은 방식은 길게 들어진 구현 클래스에서 각각의 부분을 찾는 수고를 줄일 수 있기 떄문에 이와 같은 방식이 좀 더 쉽다.
// 즉 유지 보수 부분에서 구현 하는 code 부분에서 수정해야 하는 수고를 줄일 수 있다. 
// code 부분은 수정을 하지 않아도 된다. -> 코드의 응집도를 높이는 방식 / 결합도를 낮출 수 있다.
