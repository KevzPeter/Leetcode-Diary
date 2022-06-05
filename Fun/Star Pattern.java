
/**
 * @author @kevzpeter
 * Program to print cool star pattern (idk why I made this I was bored)
 * eg : n = 10
 *           * 
 *          / \ 
 *         / * \ 
 *        / * * \ 
 *       / * * * \ 
 *      / * * * * \ 
 *     / * * * * * \ 
 *    / * * * * * * \ 
 *   / * * * * * * * \ 
 *  * - - - - - - - - * 
 */
import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        int n = (new Scanner(System.in)).nextInt();
        int spaces = n - 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            spaces--;
            if (i == n) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i)
                        System.out.print("*" + " ");
                    else
                        System.out.print("-" + " ");
                }
            } else {
                for (int j = 1; j <= i; j++) {
                    if (j == 1 && i != 1 && i != n)
                        System.out.print("/" + " ");
                    else if (j == i && i != 1 && i != n)
                        System.out.print("\\" + " ");
                    else
                        System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}