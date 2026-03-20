import java.util.ArrayList;
import java.util.Scanner;

public class inglestrab {

    // Kanban lists
    static ArrayList<String> todo = new ArrayList<>();
    static ArrayList<String> doing = new ArrayList<>();
    static ArrayList<String> done = new ArrayList<>();
    // Scanner to read user input
    static Scanner sc = new Scanner(System.in);


 // ADD TASK (adds a task to TO DO list)
    public static void addTaks(){
        System.out.println("Enter task: ");
        String task = sc.nextLine();
        todo.add(task);
        System.out.println("\nTask added to TO DO!\n");
    }
}