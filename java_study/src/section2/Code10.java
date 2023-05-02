package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code10 {
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File ("data.txt"));
			int n = in.nextInt();
			OrthoPolygon thePlolygon = new OrthoPolygon(n);
			for(int i = 0; i<n; i++)
				thePlolygon.addVertex( in.nextInt(), in.nextInt() );
			MyPoint2 p = new MyPoint2( in.nextInt(), in.nextInt() );
			in.close();
			
			if (thePlolygon.contains(p))
				System.out.println("Yes") ;
			else 
				System.out.println("No") ;
		} catch (FileNotFoundException e) {
			System.out.println("No data file exists.");
			System.exit(1);
		}
	}

}
