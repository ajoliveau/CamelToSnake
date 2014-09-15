import java.util.Scanner;
import java.util.regex.Pattern;

/** Helper to program prototype Pep/8 program in Java.
 * 
 * @author Jean Privat
 * @version 2013-01-08
 *
 * This class provides some static method to mimic some instructions of
 * the Pep/8 system.
 *
 */
class Pep8 {
	private static Scanner sc = new Scanner(System.in);

	/** DECI: Read the next integer from the input. */
	public static int deci() {
		if (!sc.hasNextInt()) {
			System.out.println("Not a valid DECI input");
			System.exit(0);
		}
		int res = sc.nextInt();
		return res;
	}
	/** DECO: Write an integer on the output. */
	public static void deco(int val) {
		System.out.print(val);
	}
	/** CHARI: Read the next character on the input. */
	public static char chari() {
		Pattern olddel = sc.delimiter();
		sc.useDelimiter("");

		if (!sc.hasNext()) {
			sc.useDelimiter(olddel);
			return 0;
		}
		String res = sc.next();
		sc.useDelimiter(olddel);
		return res.charAt(0);
	}
	/** CHARO: Write a character on the output. */
	public static void charo(char val) {
		System.out.print(val);
	}
	/** STRO: Write a string on the output. */
	public static void stro(String val) {
		System.out.print(val);
	}
	/** STRO: Write a string on the output.
	 * version with a array of char. */
	public static void stro(char[] val) {
		int len=0;
		while (len < val.length && val[len] != '\0') len++;
		char[] out = new char[len];
		for(int i=0; i<len; i++) out[i] = val[i];
		System.out.print(new String(out));
	}
	/** STOP: Terminate the program. */
	public static void stop() {
		System.exit(0);
	}
}


public class Snake {
    public static void main(String[] args) {
        int lasttype = 0; // Type du dernier caractère : 2 = majuscule, 1 = minuscule, 0 = autre
        char nextcar = Pep8.chari();
        char car = 0;
        while(nextcar != '\n' ) {
            car = nextcar;
            nextcar = Pep8.chari();
            if (car>96 && car <123) {  // Si le caractère est une lettre minuscule
                lasttype = 1;
                Pep8.charo(car);
            } else if (car>64 && car<91) { // Si le caractère est une lettre majuscule
                if (lasttype == 1)
                    Pep8.charo('_');
                else if (lasttype == 2 && nextcar > 96 && nextcar < 123) {
                    Pep8.charo('_');
                }
                Pep8.charo((char) (car+32));
                lasttype = 2;
            }
            else {
                Pep8.charo(car);
                lasttype = 0;
            }
        }
        Pep8.charo((char) 10);
        Pep8.stop();
    }

}




