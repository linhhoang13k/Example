package Arcade_Intro;

import java.util.ArrayList;

public class _42_bishopAndPawn {
    boolean bishopAndPawn(String bishop, String pawn) {
        return (Math.abs(bishop.charAt(0) - pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1)));
    }
}
