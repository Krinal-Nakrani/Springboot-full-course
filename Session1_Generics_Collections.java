import java.util.*;

/*
 =====================================================
 SESSION 1 : JAVA GENERICS & COLLECTIONS
 =====================================================
*/


// =================== GENERIC CLASS ===================
class DataStore<T> {

    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public List<T> getList() {
        return list;
    }
}


// =================== GENERIC METHOD ==================
class GenericUtility {

    public static <T> void printValue(T value) {
        System.out.println("Value: " + value);
    }
}


// =================== MAIN CLASS ======================
public class Session1_Generics_Collections {

    public static void main(String[] args) {

        // ---------- GENERIC CLASS ----------
        System.out.println("----- GENERIC CLASS -----");

        DataStore<Integer> intStore = new DataStore<>();
        intStore.add(10);
        intStore.add(25);
        intStore.add(40);

        DataStore<String> strStore = new DataStore<>();
        strStore.add("Java");
        strStore.add("Spring");
        strStore.add("React");

        System.out.println(intStore.getList());
        System.out.println(strStore.getList());


        // ---------- GENERIC METHOD ----------
        System.out.println("\n----- GENERIC METHOD -----");

        GenericUtility.printValue(100);
        GenericUtility.printValue("Hello Java");
        GenericUtility.printValue(3.14);


        // ---------- LIST ----------
        System.out.println("\n----- LIST -----");

        List<String> names = new ArrayList<>();
        names.add("Krinal");
        names.add("Amit");
        names.add("Krinal"); // duplicate allowed

        for (String name : names) {
            System.out.println(name);
        }


        // ---------- SET ----------
        System.out.println("\n----- SET -----");

        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // duplicate ignored

        System.out.println(numbers);


        // ---------- MAP ----------
        System.out.println("\n----- MAP -----");

        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Krinal");
        students.put(2, "Ravi");
        students.put(1, "Aman"); // overwrites value

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // ---------- ITERATOR ----------
        System.out.println("\n----- ITERATOR -----");

        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);

        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n == 20) {
                iterator.remove();
            }
        }

        System.out.println(nums);


        // ---------- WILDCARD ----------
        System.out.println("\n----- WILDCARD -----");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("B");
        strList.add("C");

        printAnyList(intList);
        printAnyList(strList);


        // ---------- LAMBDA FILTER ----------
        System.out.println("\n----- LAMBDA FILTER -----");

        intStore.getList()
                .stream()
                .filter(n -> n > 20)
                .forEach(System.out::println);


        // ---------- QUEUE ----------
        System.out.println("\n----- QUEUE -----");

        Queue<String> queue = new LinkedList<>();
        queue.add("Task1");
        queue.add("Task2");

        System.out.println(queue.poll());
        System.out.println(queue);


        // ---------- ARRAYS SORT ----------
        System.out.println("\n----- ARRAYS SORT -----");

        int[] arr = {5, 2, 8, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        // ---------- COLLECTION SORT ----------
        System.out.println("\n----- COLLECTION SORT -----");

        List<Integer> listToSort = new ArrayList<>();
        listToSort.add(4);
        listToSort.add(1);
        listToSort.add(3);
        listToSort.add(2);

        Collections.sort(listToSort);
        System.out.println(listToSort);


        System.out.println("\n===== SESSION 1 COMPLETED =====");
    }


    // ---------- WILDCARD METHOD ----------
    public static void printAnyList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
