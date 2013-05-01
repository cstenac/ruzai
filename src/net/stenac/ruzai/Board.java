package net.stenac.ruzai;

public class Board {
    public void setBoard(String s) {
        assert(s.length() == 16);
        for (int i = 0; i < 16; i++){
            letters[i] = s.charAt(i);
        }
    }
    
    public char[] letters = new char[16];

    /* 0   1  2  3
     * 4   5  6  7
     * 8   9 10 11
     * 12 13 14 15
     */
}
