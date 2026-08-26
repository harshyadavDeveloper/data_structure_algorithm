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

        // int[] arr = { 23, 55, 99 };
        // int i = 0;
        // arr[++i] = 30; // first i becomes 1 then arr becomes {23,30,99}
        // System.out.println(i); // prints 1
        // for(int num: arr){
        // System.out.println(num);
        // }

        // int x = 4;
        // int y = x++ + 2;
        // System.out.println(x + " " + y); // y is 6 and x is 5

        // int x = 4;
        // int y = ++x + 2;
        // System.out.println(x + " " + y); // x is 5 and y is 7

        // does changing i++ to ++i here change the final array? Reason about it before
        // testing.
        // int i = 0;
        // int[] arr = new int[5];
        // while (i < 5) {
        // arr[i] = i * 10;
        // ++i;
        // } // no it will not change output of the array because increment happens at
        // the end of the loop meaning when it uses the i that time increment had not
        // happened. pre/post does not matter here becasue new value of i obtained by
        // increment is used in the next round(iteration)
        // for (int num : arr) {
        // System.out.println(num);
        // }

        // int a = 5;
        // int b = a++ + ++a;
        // System.out.println(b); // prints 12, note: here what happened was 5 + 7 it
        // used the values first then
        // incremented it and then it first incremented the value and then used it
        // making it 7

        // int i = 3;
        // System.out.println(i++ + i++ + i); // 3 + 4 + 5 =12

        int i = 1;
        System.out.println(i++ + " " + i++ + " " + ++i); // 1 2 4

    }
}