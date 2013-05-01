package net.stenac.ruzai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Dict {
    Set<String> prefixes = new HashSet<String>();
    Set<String> words = new HashSet<String>();
    public void loadDict(File f ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        try {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                for (int i = 0; i < line.length() - 1; i++) {
                    prefixes.add(line.substring(0, i));
                }
                words.add(line);
            }
        } finally {
            br.close();
        }
    }

}
