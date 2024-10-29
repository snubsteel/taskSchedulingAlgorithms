import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class PriorityRR {
    static void schedule(ArrayList<Task> tasks, int quantum) {
        tasks.sort((a, b) -> b.priority - a.priority);
        Queue<Task> queue = new LinkedList<>();
        queue.addAll(tasks);
        RR.schedule(queue, quantum); // Reuse the Round-Robin method
    }

    public static void schedule(ArrayList<Task> tasks, int quantum, int numberOfTasksBeforeScheduling) {
        tasks.sort((a, b) -> b.priority - a.priority);
        Queue<Task> queue = new LinkedList<>();
        queue.addAll(tasks);

        int currentTime = 0;
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        int totalResponseTime = 0;

        System.out.println("Gantt Chart:");
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            int arrivalTime = task.arrivalTime;
            int burstTime = task.burstTime;

            // Calculate times
            int waitingTime = currentTime - arrivalTime;
            int turnaroundTime = waitingTime + burstTime;
            int responseTime = waitingTime;

            // Update totals
            totalTurnaroundTime += turnaroundTime;
            totalWaitingTime += waitingTime;
            totalResponseTime += responseTime;

            // Update current time
            currentTime += burstTime;

            // Print Gantt chart entry
            System.out
                    .println(task.name + " | Start time: " + (currentTime - burstTime) + " | End time: " + currentTime);

            // Print task times
            System.out.println("Turnaround time for " + task.name + ": " + turnaroundTime);
            System.out.println("Waiting time for " + task.name + ": " + waitingTime);
            System.out.println("Response time for " + task.name + ": " + responseTime);
        }

        // Calculate averages
        double averageTurnaroundTime = (double) totalTurnaroundTime / numberOfTasksBeforeScheduling;
        double averageWaitingTime = (double) totalWaitingTime / numberOfTasksBeforeScheduling;
        double averageResponseTime = (double) totalResponseTime / numberOfTasksBeforeScheduling;

        // Print averages
        System.out.println("Average turnaround time: " + averageTurnaroundTime);
        System.out.println("Average waiting time: " + averageWaitingTime);
        System.out.println("Average response time: " + averageResponseTime);
    }
}
