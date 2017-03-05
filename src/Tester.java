
public class Tester {
	public static void main(String[] args)

	{

		Fixed_Allocation ob = new Fixed_Allocation();
		ob.setJobs(10, 5, 50, 10, 18); // set new jobs
										
		ob.setMemory(70,50, 20, 5, 10); // set memory blocks
											
		ob.showData(); // display detail of available memory blocks and jobs to
						// allocate
		ob.firstFit(1, 0);
		//ob.bestFit(1,0 );
		if (ob.jobInQueue < ob.jobs) {
			ob.firstFit(1, (ob.jobInQueue + 1));
		}
	}
}