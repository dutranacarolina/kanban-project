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

    // VIEW TASKS (shows all lists)
    public static void viewTask(){
        System.out.println("\nTo Do: " + todo);
        System.out.println("Doing: " + doing);
        System.out.println("Done: " + done);

    }

 // UPDATE TASK (edit a task from TO DO)
    public static void uptadeTask(){
        // check if TO DO list is empty
        if (todo.isEmpty()){
            System.out.println("No Task!");
            return;
        }

        // Show all tasks with their index
        for (int i=0; i<todo.size(); i++){
            System.out.println(i + " - " + todo.get(i));
        }
        try{
        System.out.println("\nChoose index: ");
        int index = sc.nextInt();
        sc.nextLine();

         // validate index
        if (index <0 || index >= todo.size()){
            System.out.println("\nInvalid index!\n");
            return;
        }

        System.out.println("New name task: ");
        String newTask = sc.nextLine();

        // replace old task with new one
        todo.set(index, newTask);
        System.out.println("\nTask updated!\n");

    } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
  }

   // DELETE TASK (remove task from TO DO)
    public static void deleteTask(){
        
        if (todo.isEmpty()){
            System.out.println("No Task!");
            return;
        }
         for (int i=0; i<todo.size(); i++){
            System.out.println(i + " - " + todo.get(i));
        }
        try{
        System.out.println("\nChoose index: ");
        int index = sc.nextInt();
        sc.nextLine();

         if (index <0 || index >= todo.size()){
            System.out.println("\nInvalid index!\n");
            return;
        }

        // Ask for confirmation
        System.out.println("Are you sure you want to delete this task? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")){
            todo.remove(index);
            System.out.println("\nTask Removed!\n");
        }

        else{
            System.out.println("\nOperation cancelled\n");
        }
        } catch (Exception e){
        System.out.println("\nInvalid input! Try again\n");
        sc.nextLine();
     }
    }

}