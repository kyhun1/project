package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

	// 자료 구조 변수를 만드는것이 우선 
	static MyRectangle1 [ ] rects = new MyRectangle1 [100]; // rects 배열의 주소를 받아주는 객체 이기에 rects 지정 필요 
	static int n = 0; 

	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(new File ("data.txt"));

			//			int x = in.nextInt();
			//			int y = in.nextInt();
			//			int w = in.nextInt();
			//			int h = in.nextInt();

			//			rects[n].lu.x = x ; 
			//			rects[n].lu.y = y ;
			//			rects[n].width = w ;
			//			rects[n].height = h ;
			// 위와 같이 풀어서 쓸 수 있고 아랴와 같이 축약해서 작성 가능 

			while(in.hasNext()){
				// rects 도 참조 변수 이기에 따로 받아줄 클래스 지정 
				rects[n] = new MyRectangle1();
				// lu가 받아줄 포인트 객체를 받을 밫조 변수 생성 
				rects[n].lu = new MyPoint1(); 
				rects[n].lu.x = in.nextInt();
				rects[n].lu.y = in.nextInt();
				rects[n].width = in.nextInt();
				rects[n].height = in.nextInt();
				n++;
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("No data flie. ");
			System.exit(1);
		}
		
		bubbleSort() ; 
		
		for (int i = 0 ; i< n ; i++)
			System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " "+ rects[i].width + " " + rects[i].height);
	}

	private static void bubbleSort() {
		for (int i=n-1 ; i>0 ; i-- ) {
			for (int j = 0 ; j<i ; j++) {
				//swap 하기위해 객체를 생성하여 변환 시키는 부분을 지정 
				if ( calcArea(rects[j]) > calcArea(rects[j+1]) ) {
					MyRectangle1 tmp = rects[j] ;
					rects[j] = rects[j+1] ;
					rects[j+1] = tmp;
				}
			}
		}
	}
	
	public static int calcArea( MyRectangle1 r)
	{
		return r.width * r.height;
	}
	
}
