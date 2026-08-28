// Task 16: Given {4, 15, 7, 22, 9, 3}, find and print the average of all elements. (Careful — recall the integer-division trap 
// from a few days ago. Think about what type your sum and count need to be, or how you divide, to actually get a decimal answer 
// instead of a truncated one.)

class Main{
    public static void main(String[] args){
        int[] arr = {4, 15, 7, 22, 9, 3};
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        double average = sum/2.0;
        System.out.println(average);

    }
}