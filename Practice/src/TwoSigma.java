import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Job {
    int processTime, index;
    public Job(int processTime, int index){
        this.processTime=processTime;
        this.index=index;
    }
}
class Server {
	int totalJobProcessTime, id;
	List<Job> jobs = new ArrayList<Job>();
	public Server(int id){
		this.id=id;
		this.totalJobProcessTime=0;
	}
	public void addJob(Job job){
		this.jobs.add(job);
		this.totalJobProcessTime+=job.processTime;
	}
}
public class TwoSigma {
	static class PQDescSort implements Comparator<Job> {
		public int compare(Job a, Job b){
			return b.processTime - a.processTime;
		}
	}
	/*static class PQAscenSort implements Comparator<Server> {
		public int compare(Server a, Server b){
			return a.totalJobProcessTime - b.totalJobProcessTime;
		}
	}*/
	static int[][] serverFarm(int[] jobs, int servers) {
		int[][] result = new int[servers][];
		// max heap
	    Queue<Job> jobsPQ = new PriorityQueue<Job>(jobs.length, new PQDescSort());
	    int i = 0;
	    for(int job : jobs){
	    	Job jobObj = new Job(job, i++);
	    	jobsPQ.add(jobObj);
	    }
	    //printJobsPQ(jobsPQ);
	    // min heap
	    //Queue<Server> serverPQ = new PriorityQueue<Server>(servers);
	    
	    Server[] serversList = new Server[servers];
	    for(int j = 0; j < servers; j++){
	    	serversList[j] = new Server(j);
	    }
	    while(!jobsPQ.isEmpty()){
	    	Job job = jobsPQ.poll();
	    	// find server with the lowest job time and add job to it
	    	addToLowestServerTime(serversList, job);
	    }
	    printServersPQ(serversList);
	    return result;
	}
	
	static void addToLowestServerTime(Server[] serversList, Job job){
		int minJobTime = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < serversList.length; i++){
			if(serversList[i].totalJobProcessTime < minJobTime){
				minJobTime = serversList[i].totalJobProcessTime;
				minIndex = i;
			}
		}
		serversList[minIndex].addJob(job);
	}
	static void printJobsPQ(Queue<Job> pq){
		Job[] jobs = new Job[pq.size()];
		int i = 0;
		while(!pq.isEmpty()){
			Job job = pq.poll();
			jobs[i++] = job;
			System.out.println("Time: "+ job.processTime + "| index: "+job.index);
		}
		for(Job job : jobs){
			pq.add(job);
		}
	}
	static void printServersPQ(Server[] serversList){
		/*Server[] servers = new Server[pq.size()];
		int i = 0;
		while(!pq.isEmpty()){
			Server server = pq.poll();
			servers[i++] = server;
			System.out.print("Time: "+ server.totalJobProcessTime + "| index: "+server.id);
			// print jobs in the server
			System.out.print(" | Server: ");
			for(Job job : server.jobs){
				System.out.print(job.index + " ");
			}
			System.out.println();
		}
		for(Server server : servers){
			pq.add(server);
		}*/
		for(Server s : serversList){
			System.out.print("Time: "+s.totalJobProcessTime+"| index: "+s.id+" | Server: ");
			for(Job job : s.jobs){
				System.out.print(job.index + " ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int[] jobs = new int[]{15, 30, 15, 5, 10};
		int servers = 3;
		serverFarm(jobs,servers);
	}
}
