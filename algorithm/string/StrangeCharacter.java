package algorithm.string;

public class StrangeCharacter {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        String[] s1 = s.split(" ");

        for (String string : s1) {
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 0) {
                    sb.append(Character.toUpperCase(string.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(string.charAt(i)));
                }
            }

            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }
}
