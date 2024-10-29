import java.util.Queue;

class FCFS {
    static void schedule(Queue<Task> tasks) {
        int currentTime = 0;
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        int totalResponseTime = 0;

        System.out.println("Gantt Chart:");
        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
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
        double averageTurnaroundTime = (double) totalTurnaroundTime / tasks.size();
        double averageWaitingTime = (double) totalWaitingTime / tasks.size();
        double averageResponseTime = (double) totalResponseTime / tasks.size();

        // Print averages
        System.out.println("Average turnaround time: " + averageTurnaroundTime);
        System.out.println("Average waiting time: " + averageWaitingTime);
        System.out.println("Average response time: " + averageResponseTime);
    }

    public static void schedule(Queue<Task> fcfsQueue, int numberOfTasksBeforeScheduling) {
        int currentTime = 0;
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        int totalResponseTime = 0;

        System.out.println("Gantt Chart:");
        while (!fcfsQueue.isEmpty()) {
            Task task = fcfsQueue.poll();
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
