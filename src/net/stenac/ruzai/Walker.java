package net.stenac.ruzai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Walker {
    Dict dict;
    Board board = new Board();

    public Walker(Dict dict, String boardStr) {
        this.dict = dict;
        board.setBoard(boardStr);
    }

    Set<String> found = new HashSet<String>();

    private void walkRec(State state) {
        String curWord = state.getWord();
        if (dict.words.contains(curWord)) {
            found.add(curWord);
        }
        if (!dict.prefixes.contains(curWord)) {
            return;
        }
        for (Integer next : state.getNext()) {
            state.push(next);
            walkRec(state);
            state.pop();
        }
    }

    public void walkAll() {
        for (int i = 0 ; i < 16; i++) {
            State state = new State();
            state.board = board;
            state.push(i);
            walkRec(state);
        }
    }

    public List<String> getSortedBest() {
        List<String> f = new ArrayList<String>();
        f.addAll(found);
        Collections.sort(f, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return f;
    }
}