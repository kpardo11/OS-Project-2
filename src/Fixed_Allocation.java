import java.util.Arrays;

//page 33 Information 
//Page 522 algorithm 


public class Fixed_Allocation {

	int[] jobSize;
	int[] memorySize;
	boolean[] memoryCheck = { false, false, false, false, false };
	
	// the number of memory blocks
	int blocks;

	// the number of jobs
	int jobs;

	int theCounter;
	//int jobIndex;
	int jobInQueue;
	
	
	public void setJobs(int job1, int job2, int job3, int job4, int job5) {
		jobSize = new int[5];
		// jobs
		jobSize[0] = job1; // job 1
		jobSize[1] = job2; // job 2
		jobSize[2] = job3; // job 3
		jobSize[3] = job4; // job 4
		jobSize[4] = job5; // job 5
		jobs = jobSize.length;
	}

	public void setMemory(int memory1, int memory2, int memory3, int memory4, int memory5) {
		memorySize = new int[5];
		// available memory blocks
		memorySize[0] = memory1; // memory block 1
		memorySize[1] = memory2; // memory block 2
		memorySize[2] = memory3; // memory block 3
		memorySize[3] = memory4; // memory block 4
		memorySize[4] = memory5; // memory block 5
		blocks = memorySize.length;
	}

	public void firstFit(int countr, int jobIndex) {

		theCounter = countr;
		
		do {
			if (jobSize[jobIndex] > memorySize[theCounter - 1]) {
				theCounter++;
				
				
			} else if(memoryCheck[theCounter - 1] == true){
				theCounter++;
				
			} else{
				System.out.println("----------------------------------");
				System.out.println("Job " + (jobIndex + 1) + " of size " + jobSize[jobIndex]
						+ " has been loaded into memory block:" + theCounter);
				memorySize[theCounter - 1] = (memorySize[theCounter - 1] - jobSize[jobIndex]);
				System.out.println("The size of memory block " + theCounter + " is now " + memorySize[theCounter - 1]);
				
				memoryCheck[theCounter-1] = true;
				System.out.println("Status = " + memoryCheck[theCounter-1]);
				theCounter++;
				jobIndex++;
				
				
			}

		} while (theCounter <= blocks && jobIndex < jobs);
 
		System.out.println("----------------------------------");
		jobInQueue = jobIndex;
		if (jobInQueue < jobs) {
			System.out.println(
					"Job " + (jobInQueue + 1) + " of size " + jobSize[jobInQueue] + " is sent to waiting queue!");

		}
		

	}
	
	public void bestFit(int countr, int jobIndex){
		theCounter = countr;
		do{
			int memoryWaste = memorySize[theCounter - 1] - jobSize[jobIndex];
			int INTmemoryWaste = memorySize[0] - jobSize[0];
			
			if(jobSize[jobIndex] > memorySize[theCounter - 1]){
				theCounter +=1;
				
			} else if(memoryCheck[theCounter - 1] == true){
				theCounter += 1;
				
				}
				else{
				memoryWaste = memorySize[theCounter-1] - jobSize[jobIndex];
				System.out.println("----------------------------------");
				System.out.println("Job " + (jobIndex + 1) + " of size " + jobSize[jobIndex]
						+ " has been loaded into memory block:" + theCounter);
				memorySize[theCounter - 1] = (memorySize[theCounter - 1] - jobSize[jobIndex]);
				System.out.println("The size of memory block " + theCounter + " is now " + memorySize[theCounter - 1]);
				
				memoryCheck[theCounter-1] = true;
				System.out.println("Status = " + memoryCheck[theCounter-1]);
				
			}
			if(INTmemoryWaste > memoryWaste){
				INTmemoryWaste = memoryWaste;
				theCounter +=1;
				jobIndex += 1;
			}
		}
		while(theCounter <= blocks && jobIndex <jobs);
		
	}

	public void showData() {
		System.out.println("==========================================================================");
		System.out.println("Available memory blocks are: (" + memorySize[0] + "), (" + memorySize[1] + "),("
				+ memorySize[2] + "), (" + memorySize[3] + "), (" + memorySize[4] + ")");
		System.out.println("And jobs to allocate are: (" + jobSize[0] + "), (" + jobSize[1] + "),(" + jobSize[2]
				+ "), (" + jobSize[3] + "), (" + jobSize[4] + ")");
		System.out.println("==========================================================================");
		System.out.println("    ");
		System.out.println("===========================");
	}

	

	}


