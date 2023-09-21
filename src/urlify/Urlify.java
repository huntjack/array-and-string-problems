package urlify;

public class Urlify {
    private static final char[] URL_SPACE = {'%', '2', '0'};
    public static char[] urlify(char[] characters, int trueLength) {
        int modified = characters.length - 1;
        for(int i = trueLength - 1; i >= 0; i--) {
            if(characters[i] != ' ') {
                characters = swap(characters, i, modified);
                modified--;
            } else {
                characters = addSpace(characters, modified);
                modified -= 3;
            }
        }
        return characters;
    }
    private static char[] swap(char[] characters, int sourceIndex, int destinationIndex) {
        char temp = characters[sourceIndex];
        characters[sourceIndex] = characters[destinationIndex]; //swap?
        characters[destinationIndex] = temp;
        return characters;
    }
    private static char[] addSpace(char[] characters, int index) {
        for(int j = URL_SPACE.length - 1; j >= 0; j--) {
            characters[index--] = URL_SPACE[j];
        }
        return characters;
    }
    private static void print(char[] characters) {
        for(char character : characters) {
            System.out.print(character);
        }
    }

    public static void main(String[] args) {
        String string = "Mr John Smith    ";
        char[] charArray = string.toCharArray();
        charArray = urlify(charArray, 13);
        print(charArray);
    }
}
