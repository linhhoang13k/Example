/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_tourney;

/**
 *
 * @author raliclo
 */
public class CodeFighter_Tourney {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n, i, j;
        String[] Names = {};
        String fun = "";
        for (i = 1; i < 100; i++) {
            n = i;
            fun = "won";
            Names = new String[n];
            for (j = 0; j < n; j++) {
                Names[j] = "Name" + (j + 1);
            }
            long speedX = System.currentTimeMillis();
            System.out.println(Tourney(Names.length, Names, fun));
            Tourney(Names.length, Names, fun);
            System.out.println("#" + i + " Time spent :" + (System.currentTimeMillis() - speedX));
        }

    }

    public static String Tourney(int N, String[] Names, String fun) {
        int e = N % 2;
        int n = N / 2 + e;
        String[] x = new String[n];
        for (int i = 0; i < (N / 2); i++) {
            x[i] = fun + "(" + Names[i] + "," + Names[i + n] + ")";
        }
        if (e == 1) {
            x[n - 1] = Names[N / 2];
        }
        return N < 2 ? fun + "(" + Names[0] + ")" : N < 3 ? fun + "(" + Names[0] + "," + Names[1] + ")" : Tourney(n, x, fun);
    }

    public static String Tourney3(int N, String[] Names, String fun) {
        switch (N) {
            case 1:
                return fun + "(" + Names[0] + ")";
            case 2:
                return fun + "(" + Names[0] + "," + Names[1] + ")";
            default:
                int e = N % 2;
                int n = N / 2 + e;
                String[] Names2 = new String[n];
                for (int i = 0; i < N / 2; i++) {
                    Names2[i] = fun + "(" + Names[i] + "," + Names[i + n] + ")";
                }
                if (e == 1) {
                    Names2[n - 1] = Names[N / 2];
                }
                return Tourney(n, Names2, fun);
        }
    }
// ROW SOLUTION

    public static String Tourney2(int N, String[] Names, String fun) {
        if (N == 1) {
            return fun + "(" + Names[0] + ")";
        }
        if (N == 2) {
            return fun + "(" + Names[0] + "," + Names[1] + ")";
        }

        int e1 = N % 2;
        int n2 = N / 2 + e1;
        String[] Names2 = new String[n2];
        for (int i = 0; i < (n2 - e1); i++) {
            Names2[i] = fun + "(" + Names[i] + "," + Names[i + n2] + ")";
//            System.out.println(Names2[i]);
        }
        if (e1 == 1) {
            Names2[n2 - 1] = Names[N / 2];
//            System.out.println(Names2[n2]);
        }
        return Tourney(n2, Names2, fun);
    }
}

/*
You're given an integer N, N names and the name of the function to determine the winner.

You must build a struct that would determine the winner using the given function.
The winner is determined by the following process:

Each person from the first half of the group competes with a person from the second half of the group.
The winners compete against each other by the same rule.
The process continues until there is only one person left.

Example:

For N = 4, Names = ["Name1","Name2","Name3","Name4"], fun = "won"
The output is "won(won(Name1,Name3),won(Name2,Name4))". The first person competes against the third, the second -- against the fourth, and finally the winner compete with each other.
For 3, ["Name1","Name2","Name3"], "win"
The output is "win(win(Name1,Name3),Name2)"
For 8, ["Name1","Name2","Name3","Name4","Name5","Name6","Name7","Name8"], "won"
The output is "won(won(won(Name1,Name5),won(Name3,Name7)),won(won(Name2,Name6),won(Name4,Name8)))"
The process is described below:
[Name1]
[Name5]
[Name2] [Winner1]
[Name6] [Winner3] [...]
[Name3] [Winner2] [...]
[Name7] [Winner4]
[Name4]
[Name8]
[input] integer N

The number of people, 1 ≤ N ≤ 32
[input] array.string Names

N Names.
[input] string fun

The function name.
[output] string

Return the answer.
 */
