import java.util.*;

class FindCombinations {
    public static void main(String[] args) {
        findCombinations2();
    }

    public static void findCombinations1() {
        String[] words = { "rock", "star", "rockstar", "hello", "world" };

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                String combined = words[i] + words[j];

                for (int k = 0; k < words.length; k++) {
                    if (k != i && j != i && words[k].equals(combined)) {
                        System.out.println(words[i] + words[j]);
                    }

                }
            }

        }
    }

    public static void findCombinations2() {
        String[] words = { "rock", "star", "rockstar", "hello", "world" };

        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String combined = words[i] + words[j];
                String reversedCombined = words[j] + words[i];
                if (set.contains(combined)) {
                    System.out.println(words[i] + words[j]);
                }
                if (set.contains(reversedCombined)) {
                    System.out.println(words[j] + words[i]);
                }

            }

        }

    }
}