package string_rotation;

public class StringRotation {
    public static boolean isRotation(String base, String candidate) {
        int length = base.length();
        if(length == candidate.length() && length > 0) {
            String candidateRepeated = candidate.concat(candidate);
            return candidateRepeated.contains(base);
        }
        return false;
    }
    public static void main(String[] args) {
        String base = "waterbottle";
        String candidate = "erbottlewat";
        System.out.println(isRotation(base, candidate));
    }
}
