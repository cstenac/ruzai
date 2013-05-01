package net.stenac.ruzai;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args)  throws Exception {
        Dict dict = new Dict();
        dict.loadDict(new File(args[0]));
        
        while (true) {
            System.out.println("Enter board");
            String line = System.console().readLine();
            line = line.trim();
            if (line.length() != 16) {
                System.out.println("Wrong board (length " + line.length() + " instead of 16)");
                continue;
            }
            Walker w = new Walker(dict, line);
            w.walkAll();
            List<String> ret = w.getSortedBest();
            System.out.println("Found " + ret.size() + " words");
            for (String s : w.getSortedBest()) {
                if (s.length() >= 2) {
                    System.out.println(s);
                }
            }
            System.out.println("*****************************");
        }
    }
}
