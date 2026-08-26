// i++ and ++i both eventually do the exact same thing to i — increase it by 1. The only difference is when the increase happens relative to the value being used/returned in that same expression.
// i++ (post-increment): "use the current value first, then increase it." The expression evaluates to the old value.
// ++i (pre-increment): "increase it first, then use the new value." The expression evaluates to the new value.

class Main {
    public static void main(String[] args) {
        // int i=5;
        // int a = i++; // gets the old value of i(5), then increments it NEW(6)
        // System.out.println(a); // 5
        // System.out.println(i); // 6

        // int i = 5;
        // int b = ++i; // first increments the value and then gets it
        // System.out.println(b); // 6
        // System.out.println(i); // also 6

        // int[] arr = {23,54,31};
        // int i=0;
        // arr[i++] = 10; // arr becomes {10,54,31} and then increments(1)
        // System.out.println(i); // prints 1
        // for(int num:arr){
        // System.out.println(num);

        // }

        int[] arr = { 23, 55, 99 };
        int i = 0;
        arr[++i] = 30; // first i becomes 1 then arr becomes {23,30,99}
        System.out.println(i); // prints 1
        for(int num: arr){
            System.out.println(num);
        }

    }
}