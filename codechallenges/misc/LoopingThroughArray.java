package codechallenges.misc;

public class LoopingThroughArray {
    public static void main(String[] args) {
        String hello = "Hello World";

        iterateThroughArrMethod1(hello);
        iterateThroughArrMethod2(hello);
    }

    // TC ==> O(n)
    // SC ==> O(1)
    private static void iterateThroughArrMethod2(String hello) {
        for (int i = 0; i < hello.length(); i ++) {
            System.out.println(hello.charAt(i));
        }
    }

    // TC ==> O(2n)
    // SC ==> O(1)
    private static void iterateThroughArrMethod1(String hello) {
        for(char i: hello.toCharArray()) {
            System.out.println(i);
        }
    }
}
