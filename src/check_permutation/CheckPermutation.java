package check_permutation;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static Boolean isPermutation(String base, String candidate) {
        if(base.length() != candidate.length()) {
            return false;
        }
        Map<Character, Integer> baseCharacters = new HashMap<>();
        Map<Character, Integer> candidateCharacters = new HashMap<>();
        for(int i = 0; i < base.length(); i++) {
            char baseCharacter = base.charAt(i);
            baseCharacters = addCharacter(baseCharacter, baseCharacters);
            char candidateCharacter = candidate.charAt(i);
            candidateCharacters = addCharacter(candidateCharacter, candidateCharacters);
        }
        for(Map.Entry<Character, Integer> entry : candidateCharacters.entrySet()) {
            Character entryKey = entry.getKey();
            Integer entryValue = entry.getValue();
            if(!baseCharacters.containsKey(entryKey)) {
                return false;
            }
            Integer baseValue = baseCharacters.get(entryKey);
            if(!baseValue.equals(entryValue)) {
                return false;
            }
        }
        return true;
    }
    private static Map<Character, Integer> addCharacter(char character, Map<Character, Integer> characterMap) {
        int count = 0;
        if(characterMap.containsKey(character)) {
            count = characterMap.get(character);
        }
        characterMap.put(character, ++count);
        return characterMap;
    }
    public static void main(String[] args) {
        String base = "Mississippi State";
        String permutation = "MeitsastiSs siipp";
        String notPermutation = "MeitsastiSs ssipp";
        System.out.println("Should be true: " + isPermutation(base, permutation));
        System.out.println("Should be false: " + isPermutation(base, notPermutation));
    }
}
