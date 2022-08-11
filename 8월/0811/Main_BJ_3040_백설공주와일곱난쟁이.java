package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3040_백설공주와일곱난쟁이 {

    static boolean[] isSelected;
    static int[] num;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        num = new int[9];
        isSelected = new boolean[9];

        for(int i=0;i<9;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        subset(0, 0, 0);



    }//main

    public static void subset(int idx, int sum, int cnt) {

        if(idx == 9){
            if(sum==100){
                for (int i = 0; i < 9; i++) {
                    if(isSelected[i]){
                        System.out.println(num[i]);
                    }
                }
                System.exit(0);
            }
            return;
        }




        isSelected[idx] = true;
        subset( idx+1, sum + num[idx], cnt+1);
        isSelected[idx] = false;
        subset( idx+1, sum, cnt);
    }


}//end class
