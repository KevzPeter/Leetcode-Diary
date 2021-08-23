/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef_Time
{
	public static int time_converter(String time) {
		int P = 0;
		if (time.substring(time.length() - 2).equals("AM")) {
			if (time.substring(0, 2).equals("12")) {
				if (time.charAt(3) == '0') {
					P += Integer.parseInt(time.substring(4, 5));
				} else {
					P += Integer.parseInt(time.substring(3, 5));
				}
			} else {
				if (time.charAt(0) == '0') {
					P += Integer.parseInt(time.substring(1, 2)) * 60;
				} else {
					P += Integer.parseInt(time.substring(0, 2)) * 60;
				}
				if (time.charAt(3) == '0') {
					P += Integer.parseInt(time.substring(4, 5));
				} else {
					P += Integer.parseInt(time.substring(3, 5));
				}
			}
		}
		if (time.substring(6).equals("PM")) {
			if (time.substring(0, 2).equals("12")) {
				P += Integer.parseInt(time.substring(0, 2)) * 60;
			} else {
				if (time.charAt(0) == '0') {
					P += (Integer.parseInt(time.substring(1, 2)) + 12) * 60;
				} else {
					P += (Integer.parseInt(time.substring(0, 2)) + 12) * 60;
				}
			}
			if (time.charAt(3) == '0') {
				P += Integer.parseInt(time.substring(4, 5));
			} else {
				P += Integer.parseInt(time.substring(3, 5));
			}
		}
		return (P);
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int i = 0; i < T; i++) {
			int Main_Time = 0;
			int Slot_s = 0;
			int Slot_e = 0;
			String time = in.nextLine();
			int n = in.nextInt();
			String slot[] = new String[n];
			for (int j = 0; j < n; j++) {
				slot[j] = in.nextLine();
			}
			for (int j = 0; j < n; j++) {
				Main_Time = time_converter(time);
				Slot_s=time_converter(slot[j].substring(0,8));
				Slot_e=time_converter(slot[j].substring(9));
				if(Main_Time>=Slot_s && Main_Time<=Slot_e){
					System.out.print("1");
				}
				else{
					System.out.print("0");
				}
		    }
		}
	}
}
