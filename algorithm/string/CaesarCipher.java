package algorithm.string;

public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            }

            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + n) % 26 + 'a'));
            }

            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + n) % 26 + 'A'));
            }
        }

        return sb.toString();

    }
}
