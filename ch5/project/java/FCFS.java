import java.util.ArrayList;
import java.util.List;

public class FCFS implements Algorithm {
    private double total_waiting_time =0;
    private double total_turnaround_time =0;
    private double average_waiting_time;
    private double average_turnaround_time;

    List<Task> queue = new ArrayList<Task>();
    private int current_task =0;
    public FCFS(List queue){
        this.queue = queue;
        System.out.println("FCFS Scheduling");
        schedule();
        average_waiting_time = total_waiting_time/ queue.size();
        average_turnaround_time = total_turnaround_time/ queue.size();
        System.out.println("Average Times: Waiting [ " + average_waiting_time + " ]  turnaround [ " + average_turnaround_time + " ]" );

    }
    @Override
    public void schedule() {
        while(this.queue.size() !=0 ){
            System.out.println("Will run " + pickNextTask());
            pickNextTask().run();
            System.out.println("completion time: "+pickNextTask().completionTime);
            total_waiting_time += pickNextTask().getWaitingTime();
            total_turnaround_time += pickNextTask().getTurnaroundTime();
            System.out.println("task " + pickNextTask().getName()+ " finished.\n");
            this.queue.remove(current_task);

        }
    }

    @Override
    public Task pickNextTask() {
        return this.queue.get(current_task);
    }
}