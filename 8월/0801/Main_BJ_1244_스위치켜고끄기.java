import java.util.Arrays;
import java.util.Scanner;


public class Main_BJ_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		
		// 남학생은 켜고 끄기만
		// 여학생은 가장 대칭이 많은 구간 찾아서 바꾸기 
		
		Scanner sc = new Scanner(System.in);
		
		int btn = sc.nextInt();
		int []arr = new int[btn];
		
		for(int i=0;i<btn;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int student = sc.nextInt();

		int sex;
		int num;
		
		for(int t=0;t<student;t++) {
			
			sex = sc.nextInt();
			num = sc.nextInt();
			
			//남학생
			if(sex==1) {
				for(int j=0;j<btn;j++) {
					if((j+1) % num == 0) {
						arr[j] = arr[j] == 1 ? 0 : 1;
					}
				}
//				System.out.println(Arrays.toString(arr));
			}
			
			
			//여학생
			else {
				arr[num-1] = arr[num-1] == 1 ? 0 : 1;
				
				for(int i = 1; i<btn/2; i++) {
					if (num-1-i < 0 || num-1+i >= btn)	break;
					if(arr[num-1-i] == arr[num-1+i]) {
						arr[num-1-i] = arr[num-1-i] == 1 ? 0 : 1;
						arr[num-1+i] = arr[num-1+i] == 1 ? 0 : 1;
					}
					else {
						break;
					}
				}
								
			}	
			
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
		
	}//main
}
