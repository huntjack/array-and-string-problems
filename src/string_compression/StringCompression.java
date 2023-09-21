package string_compression;

public class StringCompression {
    public static String stringCompression(String string) {
        if(calculateCompressedLength(string) > string.length()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char current = Character.MIN_VALUE;
        int currentCount = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != current) {
                if(currentCount > 0) {
                    stringBuilder.append(currentCount);
                }
                current = string.charAt(i);
                stringBuilder.append(current);
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        stringBuilder.append(currentCount);
        return stringBuilder.toString();
    }
    private static int calculateCompressedLength(String string) {
        char current = Character.MIN_VALUE;
        int characterGroups = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != current) {
                current = string.charAt(i);
                characterGroups++;
            }
        }
        return characterGroups * 2;
    }
    public static void main(String[] args) {
        String test = "aabcccccaaaAA";
        String test2 = "AbCdEfG";
        System.out.println(stringCompression(test));
        System.out.println(stringCompression(test2));
    }
}
