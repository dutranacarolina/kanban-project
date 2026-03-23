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
        try{
        limparTela();
        System.out.println("Enter task: ");
        String task = sc.nextLine();

        if (!task.trim().isEmpty()){
            todo.add(task);
            System.out.println("Task added to TO DO!");
        }
        else{
            System.out.println("No task added!");
        }
        
        System.out.println("\nENTER to continue");
        sc.nextLine();
       
        } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
      
    }

    // VIEW TASKS (shows all lists)
    public static void viewTask(){
        try{
        limparTela();
        System.out.println("\nTo Do: " + todo);
        System.out.println("Doing: " + doing);
        System.out.println("Done: " + done);

        System.out.println("\nENTER to continue");
        sc.nextLine();
       

        } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
    }

 // UPDATE TASK (edit a task from TO DO)
    public static void uptadeTask(){

         ArrayList<String> lista = escolherLista();

        if (lista == null || lista.isEmpty()){
            System.out.println("\nNo Task!\n");
            return;

        }
        limparTela();
        // Show all tasks with their index
        for (int i=0; i<lista.size(); i++){
            System.out.println(i + " - " + lista.get(i));
        }

        try{
    
        System.out.println("\nChoose index: ");
        int index = sc.nextInt();
        sc.nextLine();

         // validate index
        if (index <0 || index >= lista.size()){
            System.out.println("\nInvalid index!\n");
            return;
        }

        System.out.println("New name task: ");
        String newTask = sc.nextLine();

        // replace old task with new one
        if (!newTask.trim().isEmpty()) {
             lista.set(index, newTask);
             System.out.println("\nTask updated!\n");
        }
        else{
            System.out.println("\nNo uptade made\n");
        }

        System.out.println("\nENTER to continue");
        sc.nextLine();
       
         
    } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
  }

   // DELETE TASK (remove task from TO DO)
    public static void deleteTask(){
        
       ArrayList<String> lista = escolherLista();

        if (lista == null || lista.isEmpty()){
            System.out.println("\nNo Task!\n");
            return;
        }
        
        limparTela();
         for (int i=0; i<lista.size(); i++){
            System.out.println(i + " - " + lista.get(i));
        }
        try{
        
        System.out.println("\nChoose index: ");
        int index = sc.nextInt();
        sc.nextLine();

         if (index <0 || index >= lista.size()){
            System.out.println("\nInvalid index!\n");
            return;
        }

        // Ask for confirmation
        System.out.println("Are you sure you want to delete this task? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")){
            lista.remove(index);
            System.out.println("\nTask Removed!\n");
        }

        else{
            System.out.println("\nOperation cancelled\n");
        }

        System.out.println("\nENTER to continue");
        sc.nextLine();
       

        } catch (Exception e){
        System.out.println("\nInvalid input! Try again\n");
        sc.nextLine();
     }
 }

     //  MOVE TO DO → DOING
    public static void moveTODoing(){
        try{
        if (!todo.isEmpty()){
              // Remove first task from TO DO and add to DOING
            doing.add(todo.remove(0));
            System.out.println("\nMoved to Doing!\n");
        }
        else{
            System.out.println("\nNo tasks in TO Do!\n");
        }

        System.out.println("\nENTER to continue");
        sc.nextLine();
       

     } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
    }

    // MOVE DOING → DONE
    public static void moveToDone(){
        try{
        if (!doing.isEmpty()){
            done.add(doing.remove(0));
            System.out.println("\nMoved to Done!\n");
        }
        else{
            System.out.println("\nNo tasks in Doing!\n");
        }

        System.out.println("\nENTER to continue");
        sc.nextLine();
       

        } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
    }

     // VIEW BOARD (show Kanban board)
    public static void viewBoard(){
        try{
        System.out.println("\nTo Do: " + todo);
        System.out.println("Doing: " + doing);
        System.out.println("Done: " + done);

        System.out.println("\nENTER to continue");
        sc.nextLine();
       

        } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
    }

    // Choose which list to modify
    public static ArrayList<String>escolherLista(){

    try{
    limparTela();
    System.out.println("\nChoose the list:     ");
    System.out.println("1 - To Do              ");
    System.out.println("2 - Doing              ");
    System.out.println("3 - Done               ");

    int escolha = sc.nextInt();
    sc.nextLine();

    if (escolha == 1) return todo;
    if (escolha == 2) return doing;
    if (escolha == 3) return done;

    System.out.println("\nENTER to continue");
        sc.nextLine();
       

    System.out.println("\nInvalid option!\n");
    return null;

    

    } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
        return null;
    }
    }

   public static void limparTela() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        System.out.println("Não foi possível limpar a tela.");
    }
}

     // MAIN METHOD (main menu)
    public static void main(String[] args) {
        int option;
        try{
        do{
            limparTela();
            System.out.println("         KANBAN MENU             ");
            System.out.println("1 - Add task                     ");
            System.out.println("2 - View task                    ");
            System.out.println("3 - Uptade task                  ");
            System.out.println("4 - Remove task                  ");
            System.out.println("5 - Move TO DO → DOING           ");
            System.out.println("6 - Move DOING → DONE            ");
            System.out.println("7 - View Board                   ");
            System.out.println("0 - Back                         ");
            System.out.println("Choose an option:                ");
            

            option = sc.nextInt();
            sc.nextLine();
            

            switch (option) {
                case 1:
                    addTaks();
                    break;

                case 2:
                    viewTask();
                    break;

                case 3:
                    uptadeTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    moveTODoing();
                    break;

                case 6:
                    moveToDone();
                    break;

                case 7:
                    viewBoard();
                    break;


                case 0:
                    System.out.println("Exiting the program...");
                    break;
                
                default:
                    System.out.println("Invalid option!");
                    break;
            }

        } while (option != 0);

    } catch (Exception e){
        System.out.println("Invalid input! Try again");
        sc.nextLine();
    }
        
    }
    
}
   