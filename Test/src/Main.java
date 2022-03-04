
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] Args) throws IOException {
//1. Combine a list of Strings using comma separator. 
		Combine();
//2. To give best experience to users who visit the website, the owner wants to know during which period of time load is high so that he can scale up servers. 
//		Given a log file having details of users visit(consider VISITID is logged) and other log messages, find out the duration(1 hour) during which load is high.
		LogFile();
//1. Given a string print every third character only if it a vowel
		everyThirdCharVowel();
//2. rotate string
		RotateString();
//3. reverse the given string		
		ReverseString();
//4. check whether a given string is palindrome		
		Palindrome();

	}

	public static void Combine() {
		String[] Planets = { "Mercury", "Venus", "Mars" };

		System.out.println(Arrays.stream(Planets).map(Object::toString).reduce("PLANETS:", (st1, st2) -> {
			if (st2.equals("Mercury")) {
				return st1 + st2;
			}
			return st1 + "," + st2;
		}));
		System.out.println("Planets2:"+Arrays.stream(Planets).collect(Collectors.joining(",")));

		System.out.println("\n");

	}

	public static void LogFile() throws IOException {
		String lines = null;
		String Mayor = null;		
		String LastHr=null;
		int MayorCount=0,currentCount=0;
		
		FileInputStream fstream = new FileInputStream(
				"C:\\Users\\kevindaryl.ibarr\\eclipse-workspace\\Test\\src\\LogFile.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		while ((lines = br.readLine()) != null) {
			if (lines.contains("UserId")) {				
				String [] time = lines.split(" ");
				
				String [] Hr = time[0].split(":");				
				String CurrentHr = Hr[1];
				
				if(LastHr==null) {
					currentCount += 1;
				}else {
					if(CurrentHr.equals(LastHr)) {
						currentCount += 1;	
					}else {
						if(currentCount > MayorCount) {
							MayorCount = currentCount;
							Mayor = LastHr;
						}
						//clear count
						currentCount =1;
					}
				}				

				LastHr = CurrentHr;
			}
		}
		System.out.println("high:"+Mayor);
		System.out.println("\n");
	}

	public static void everyThirdCharVowel() {
		String s = "thislolmilmi";
		char[] sc = s.toCharArray();
		char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u' };

		for (int x = 1; x <= s.length() - 1; x++) {
			if (x % 3 == 0) {
				for (int y = 0; y < vowel.length; y++) {
					if (sc[x - 1] == vowel[y]) {
						System.out.println("third vowel: " + sc[x - 1]);
					}
				}
			}
			if (s.length() - 1 == x) {
				if (s.length() % 3 == 0) {
					for (int y = 0; y < vowel.length; y++) {
						if (sc[x] == vowel[y]) {
							System.out.println("third vowel: " + sc[x]);
						}
					}
				}
			}
		}
		System.out.println("\n");

	}

	public static void RotateString() {
		AtomicInteger count = new AtomicInteger(5);
		String s = "String";

		System.out.println("Rotate:");
//		for(int x = 1; x<=times;x++) {
//				System.out.print(s.substring(s.length()-x, s.length()));
//				System.out.println(s.substring(0, s.length()-x));
//		}

		String reversed = s.chars().mapToObj(chara -> (char) chara).reduce("", (stri, chara) -> chara + stri,
				(stri1, stri2) -> {
					if (count.get() < 3) {
						return stri2 + stri1;
					}
					count.getAndIncrement();
					return stri1;
				});
		System.out.println("contador:" + count.get());
		System.out.println("Rotate:" + reversed);
		System.out.println("");

	}

	public static void ReverseString() {

		String str = "Kevin";

		System.out.println("Reverse:");

		String reversed = str.chars().mapToObj(chara -> (char) chara).reduce("", (stri, chara) -> chara + stri,
				(stri1, stri2) -> stri2 + stri1);

		System.out.println(reversed);
		System.out.println("\n");

	}

	public static void Palindrome() {
		String str = "cbc";

		boolean reversed = str.chars().mapToObj(chara -> (char) chara)
				.reduce("", (stri, chara) -> chara + stri, (stri1, stri2) -> stri2 + stri1).equals(str);

		if (reversed) {
			System.out.println("Palindrome");
		} else {
			System.out.println("No Palindrome");
		}

	}

}
