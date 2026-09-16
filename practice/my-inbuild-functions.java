class MyInbuildFunctions {
    public static void main(String[] args) {
        boolean isPattern = contains("cat", "at");
        char chars = myCharAt("harsh", 2);
        // System.out.println(isPattern);
        // System.out.println(chars);
        // int minNum = myMin(-200, -40);
        // System.out.println(minNum);
        // int maxNum = myMax(-200, 40);
        // System.out.println(maxNum);
        int myAbss = myAbs(0);
        System.out.println(myAbss);

    }

    public static boolean contains(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0)
            return true;

        if (m > n)
            return false;
        int max = n = m;

        for (int i = 0; i <= max; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;

    }

    public static char[] myToCharArray(String word) {
        /// 1. get the length of the word and create a new arr
        /// 2. start the loop till the end of the valid index
        /// 3. start putting char from from word into the new arr one by one using
        /// charAt
        int n = word.length();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = myCharAt(word, i);
        }
        return arr;
    }

    public static char myCharAt(String word, int index) {
        /// 1. throw an exception if the provide index is out of bound
        /// 2. get char[] and return the char based on the provided index
        if (index < 0 || word.length() <= index) {
            throw new IndexOutOfBoundsException("Invalid Index " + index);
        }

        char[] arr = word.toCharArray();
        return arr[index];
    }

    public static int myMin(int a, int b) {
        /// 1. verry simple returns the minimun number out of the 2
        if (a < b) {
            return a;
        }
        return b;
    }

    public static int myMax(int a, int b) {
        /// 1. very simple returns the maximun out of the 2
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int myAbs(int x) {
        /// 1. this is not just about flipping the sign it tell us how far is the number
        /// from 0
        if (x < 0) {
            return -x;
        }
        return x;
    }
}