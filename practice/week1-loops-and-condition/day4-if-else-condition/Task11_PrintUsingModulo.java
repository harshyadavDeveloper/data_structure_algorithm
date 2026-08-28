// Task 11: For numbers 1 to 20, print the number itself if it's divisible by 3, and print "skip" otherwise. (This is testing 
// whether you can adapt the even/odd modulo logic to a different divisor.)

class Main{
    public static void main(String[] args){
        for(int i=1;i<=20;i++){
            if(i%3==0){
                System.out.println(i);
            }else{
                System.out.println("skip");
            }
        }

    }
}