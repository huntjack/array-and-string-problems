package is_unique;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
        public static Boolean isUniqueWithSet(String string) {
            if(string.length() > 128) {
                return false;
            }
            Set<Character> characterSet = new HashSet<>();
            for(int i = 0; i < string.length(); i++) {
                Character character = string.charAt(i);
                if(!characterSet.contains(character)) {
                    characterSet.add(character);
                } else {
                    return false;
                }
            }
            return true;
        }
        public static Boolean isUniqueWithBitVector(String string) {
            if(string.length() > 26) {
                return false;
            }
            int checker = 0;
            for(int i = 0; i < string.length(); i++) {
                char character = string.charAt(i);
                if(character >= 'a' && character <= 'z') {
                    int bitElement = character - 'a';
                    int mask = 1 << bitElement;
                    if((checker & mask) != 0) {
                        return false;
                    }
                    checker |= mask;
                }
            }
            return true;
        }
        public static Boolean isUniqueInPlaceWithArray(char[] charArray) {
            int lastIndex = charArray.length - 1;
            charArray = quickSort(charArray, 0, lastIndex);
            for(int i = 0; i < lastIndex; i++) {
                if(charArray[i] == charArray[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        private static char[] quickSort(char[] charArray, int left, int right) {
            if(left < right) {
                char pivotValue = charArray[right];
                int lessThanPivot = left - 1;
                int equalToPivot = right;
                int i = left;
                while(i < equalToPivot) {
                    if(charArray[i] < pivotValue) {
                        charArray = swap(charArray, ++lessThanPivot, i++);
                    } else if(charArray[i] == pivotValue) {
                        charArray = swap(charArray, i, --equalToPivot);
                    } else {
                        i++;
                    }
                }
                int j = lessThanPivot + 1;
                while(equalToPivot <= right) {
                    charArray = swap(charArray, j++, equalToPivot++);
                }
                int pivotIndex = j - 1;
                charArray = quickSort(charArray, left, lessThanPivot);
                charArray = quickSort(charArray, pivotIndex + 1, right);
            }
            return charArray;
        }
        private static char[] swap(char[] charArray, int elementOne, int elementTwo) {
            char temp = charArray[elementOne];
            charArray[elementOne] = charArray[elementTwo];
            charArray[elementTwo] = temp;
            return charArray;
        }
    public static void main(String[] args) {
        String unique = "jackson";
        char[] uniqueArray = unique.toCharArray();
        String notUnique = "kansas";
        char[] notUniqueArray = notUnique.toCharArray();
        String trueString = "Should be true: ";
        String falseString = "Should be false: ";
        System.out.println(trueString + isUniqueWithSet(unique));
        System.out.println(falseString +isUniqueWithSet(notUnique));
        System.out.println(trueString + isUniqueWithBitVector(unique));
        System.out.println(falseString + isUniqueWithBitVector(notUnique));
        System.out.println(trueString + isUniqueInPlaceWithArray(uniqueArray));
        System.out.println(falseString + isUniqueInPlaceWithArray(notUniqueArray));
    }
}
