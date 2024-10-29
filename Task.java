class Task {
    String name;
    int priority;
    int burstTime;
    int arrivalTime;

    // Constructor with four parameters
    Task(String name, int priority, int burstTime, int arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    // Constructor with three parameters
    Task(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = 0; // Default arrival time
    }
}
