import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("Enter the number of tasks:");
        int numberOfTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("Enter task " + (i + 1) + " details (format: name priority burstTime):");
            String taskDetails = scanner.nextLine();
            String[] parts = taskDetails.split(" ");
            String name = parts[0];
            int priority = Integer.parseInt(parts[1]);
            int burstTime = Integer.parseInt(parts[2]);
            tasks.add(new Task(name, priority, burstTime, 0)); // All tasks are assumed to arrive at the same time
        }

        boolean continueScheduling = true;
        while (continueScheduling) {
            int numberOfTasksBeforeScheduling = tasks.size(); // Store the number of tasks before scheduling
            System.out.println("Choose a scheduling algorithm:");
            System.out.println("1. FCFS\n2. SJF\n3. Priority\n4. Round-Robin\n5. Priority with Round-Robin");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nFCFS Scheduling:");
                    Queue<Task> fcfsQueue = new LinkedList<>(tasks);
                    FCFS.schedule(fcfsQueue, numberOfTasksBeforeScheduling); // Pass the number of tasks to the schedule method
                    break;
                case 2:
                    System.out.println("\nSJF Scheduling:");
                    SJF.schedule(tasks, numberOfTasksBeforeScheduling); // Pass the number of tasks to the schedule method
                    break;
                case 3:
                    System.out.println("\nPriority Scheduling:");
                    PriorityScheduling.schedule(tasks, numberOfTasksBeforeScheduling); // Pass the number of tasks to the schedule method
                    break;
                case 4:
                    System.out.println("\nRound-Robin Scheduling:");
                    Queue<Task> rrQueue = new LinkedList<>(tasks);
                    RR.schedule(rrQueue, 10, numberOfTasksBeforeScheduling); // Pass the number of tasks to the schedule method
                    break;
                case 5:
                    System.out.println("\nPriority with Round-Robin Scheduling:");
                    PriorityRR.schedule(tasks, 10, numberOfTasksBeforeScheduling); // Pass the number of tasks to the schedule method
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("Would you like to try another scheduling algorithm? (yes/no)");
            String userResponse = scanner.next();
            continueScheduling = userResponse.equalsIgnoreCase("yes");
        }

        scanner.close();
    }
}
