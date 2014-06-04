
package Dicionario;

import java.util.HashMap;

/**
 *
 * @author Geovanni Rocha
 */

public interface IDicionario {
    public HashMap removeStopWord(HashMap<Integer, String> tolkenMap);
    public boolean isStopWord(String word);
    public void addStopWord(String word);
    public HashMap<Integer,String> sort(HashMap<Integer, String> tolkenMap);
    
}
