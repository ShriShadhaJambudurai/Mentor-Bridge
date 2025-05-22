import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class StreamArrayList {
    public static void main(String args[]){
        List<Integer>nums = new ArrayList<>();
        nums.add(4);
        nums.add(8);
        nums.add(9);
        nums.add(2);
        nums.add(5);
        Stream<Integer>data = nums.stream();
        data.forEach(n-> System.out.println(n));
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter element to search");
        int search = obj.nextInt();
        Optional<Integer> result = nums.stream().filter(n->n.equals(search)).findFirst();
        if(result.isPresent()){
            System.out.println("Element Found"+result.get());
        }
        else{
            System.out.println(search+"not found");
        }
    }
}
