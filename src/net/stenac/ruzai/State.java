package net.stenac.ruzai;

import java.util.ArrayList;
import java.util.List;

public class State {
    public Board board;
    private boolean[] used = new boolean[16];
    private List<Integer> stack = new ArrayList<Integer>();
    
    public void push(int pos) {
        used[pos] = true;
        stack.add(pos);
    }
    public void pop() {
        assert (stack.size() > 0);
        int pos = stack.remove(stack.size() - 1);
        assert(used[pos]);
        used[pos] = false;
    }
    
    public List<Integer> getNext() {
        List<Integer> ret = new ArrayList<Integer>();
        int lastpos = stack.get(stack.size() - 1);
        assert(used[lastpos]);
        /* Up-right */
        if (lastpos >= 4 && lastpos % 4 != 0 && !used[lastpos-5]) ret.add(lastpos-5);
        /* Up */
        if (lastpos >= 4 && !used[lastpos-4]) ret.add(lastpos-4);
        /* Up left */
        if (lastpos >= 4 && lastpos % 4 != 3 && !used[lastpos-3]) ret.add(lastpos-3);
        /* Left */
        if (lastpos % 4 != 0 && !used[lastpos-1]) ret.add(lastpos-1);
        /* Right */
        if (lastpos % 4 != 3 && !used[lastpos+1]) ret.add(lastpos+1);
        /* Down-right */
        if (lastpos < 12 && lastpos % 4 != 0 && !used[lastpos+3]) ret.add(lastpos+3);
        /* Down */
        if (lastpos < 12 && !used[lastpos+4]) ret.add(lastpos+4);
        /* Down left */
        if (lastpos < 12 && lastpos % 4 != 3 && !used[lastpos+5]) ret.add(lastpos+5);
        return ret;
    }
    
    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(board.letters[i]);
        }
        return sb.toString();
    }
}
