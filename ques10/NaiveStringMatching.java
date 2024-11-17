public class NaiveStringMatching {
      public static void main(String[] args) {
        String text = "ABABABABC";
        String pattern = "ABAB";

        long startTime = System.nanoTime();
        naiveSearch(text, pattern);
        long endTime = System.nanoTime();
        System.out.println("Naive Algorithm execution time: " + (endTime - startTime) + " ns");
    }

    public static void naiveSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }

  }
