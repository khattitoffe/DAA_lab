public class RabinKarp {
     public static void main(String[] args) {
        String text = "ABABABABC";
        String pattern = "ABAB";
        
        long startTime = System.nanoTime();
        rabinKarpSearch(text, pattern);
        long endTime = System.nanoTime();
        
        System.out.println("Rabin-Karp Algorithm execution time: " + (endTime - startTime) + " ns");
    }
    public static void rabinKarpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int prime = 101; 
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * 256) % prime;
        }

        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * 256 + pattern.charAt(i)) % prime;
            textHash = (textHash * 256 + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                int j = 0;
                while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            if (i < n - m) {
                textHash = (256 * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (textHash < 0) {
                    textHash += prime;
                }
            }
        }
    }
}
