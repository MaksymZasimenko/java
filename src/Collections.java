import java.lang.reflect.Array;
import java.util.*;

public class Collections {
    public static void main(String[] args) {

        //Stack
        Stack<String> stack = new Stack<String>();
        //push();
        stack.push("1");

        System.out.println(stack);
        stack.remove("1");
        System.out.println(stack);



//
//        Queue<Integer> q = new LinkedList<>();
//            for(int i = 0 ; i < 5; i++){
//                q.add(i);
//        }
//        System.out.println(q);
//
//            int remove = q.remove();
//        System.out.println(q);
//
//        int head = q.peek();
//        System.out.println(head);
//
//        int size = q.size();
//        System.out.println(size);

//        //HashSet
//
//        HashSet<String> cars = new HashSet<>();
//        cars.add("BMW");
//        cars.add("Honda");
//        cars.add("Mazda");
//
//        //contains()
//        System.out.println(cars.contains("BMW"));
//
//        //remove()
//        cars.remove("BMW");
//        System.out.println(cars);
//
//        //size()
//        System.out.println(cars.size());
//
//        //clear()
//        cars.clear();
//        System.out.println(cars);






        //Map
//
//        HashMap<String, String> capitalCities = new HashMap<String, String>();
//        //Add keys and values put()
//        capitalCities.put("USA", "DC");
//        capitalCities.put("UK", "London");
//        capitalCities.put("Germany", "Berlin");
//        //
//
//        //get()
//        System.out.println(capitalCities.get("USA"));
//
//        //remove();
//       capitalCities.remove("UK");
//        System.out.println(capitalCities);
//
//        //size()
//        System.out.println(capitalCities.size());
//
//        for(String i: capitalCities.keySet()){
//            System.out.println(i + " " + capitalCities.get(i));
//        }






//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(5);
////        arr.add(6);
//
//        System.out.println(arr);
//        System.out.println(arr.size());
//        //set() modify whatever element we want inside
//        arr.set(0, 9);
//        System.out.println(arr);
//        //remove() removes elements
//        arr.remove(0);
//        System.out.println(arr);
//        //clear() clears all the elemnts
//        arr.clear();
//        System.out.println(arr);
    }
}
