import java.util.Scanner;

public class DictionaryTester {
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Dictionary Tester.\n");

        System.out.println("First, test isEmpty. Should return true: " + d.isEmpty());
        System.out.println("Next, test size. Should return 0: " + d.size());
        System.out.println("Next, test .contains(). Should return false: " + d.contains("Test") + "\n");

        System.out.print("Now we will test a Key-Value Pair, Please give me a Key: ");
        String key = s.next();
        System.out.print("\nPlease give me a corresponding value to complete the pair: ");
        String value = s.next();
        d.put(key,value);
        System.out.println("\nTo clarify, your Key-Val pair is: " + key + "-" + value + "\n");
        System.out.println("First, test isEmpty. Should return false: " + d.isEmpty());
        System.out.println("Next, test size. Should return 1: " + d.size());
        System.out.print("Now we will test a second Key-Value Pair, Please give me a Key: ");
        key = s.next();
        System.out.print("\nPlease give me a corresponding value to complete the pair: ");
        value = s.next();
        d.put(key,value);
        System.out.println("\nTo clarify, your second Key-Val pair is: " + key + "-" + value + "\n");
        System.out.println("First, test isEmpty. Should return false: " + d.isEmpty());
        System.out.println("Next, test size. Should return 2: " + d.size() + "\n");
        System.out.print("Now, lets test the Key reciever. Give me one of your two keys, and I'll give an output:");
        key = s.next();
        value = (String) d.get(key);
        System.out.println("\nThe value of " + key + " is " + value + "\n");
        System.out.println("Now we're gonna delete one of the keys, give me which you want to delete: ");
        key = s.next();
        d.remove(key);
        System.out.println("First, test isEmpty. Should return false: " + d.isEmpty());
        System.out.println("Next, test size. Should return 1: " + d.size());
        System.out.print("Now, lets test the Key reciever. Give me the remaining of your keys, and I'll give the output:");
        key = s.next();
        value = (String) d.get(key);
        System.out.println("\nThe value of " + key + " is " + value + "\n");
    }
}
