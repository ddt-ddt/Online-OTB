import java.util.HashMap;
import java.util.Vector;

public class OTB {
	static DcConfiguration conf=new DcConfiguration();
	static //VM
	double VM[][] = conf.getVM();
	
	public static void OTB(int JobNumber){
		int ServerNumber=conf.getServerNumber();
		JobConfiguration job[]=new JobConfiguration[JobNumber+1];
		double P=0.0;
		int ServerNumberNow=0;
		int ServerNumberTemp=0;
		
		double C1=conf.getC1();
		double C2=conf.getC2();
		double CPU_CORE=conf.getCPU_CORE();
		
		for(int i=1;i<=JobNumber;i++){
			job[i]=new JobConfiguration(i);
		}
		HashMap<Integer,Vector> ServerJob =new HashMap<Integer, Vector>();
		for(int i=0;i<ServerNumber;i++)
		{
			Vector v = new Vector();
			ServerJob.put(i,v);
		}
		
		double[] UtilizationServer=new double[ServerNumber];
		double[][] ActualUtilizationServer = new double[ServerNumber][3];
		for(int i=0;i<ServerNumber;i++){
			ActualUtilizationServer[i][0]=100;
			ActualUtilizationServer[i][1]=100;
			ActualUtilizationServer[i][2]=100;
		}
		
		int[] ServerStartTime=new int[ServerNumber];
		int[] ServerFinishTime=new int[ServerNumber];
		
		for(int i=0;i<ServerNumber;i++){
			ServerFinishTime[i]=0;
			ServerStartTime[i]=1000000;
		}
		double Energy=0.0;
		
		Vector OnDo_Job = new Vector();
		Vector Done_Job = new Vector();
		
		for(int i=1;i<=JobNumber;i++){
System.out.println();
System.out.println("Job::"+i);
			OnDo_Job.add(i);
			int T_now=job[i].getArrive_Time();
System.out.println("T_now:"+T_now);
			int vn=job[i].getVn();		
			
			for(int j=0;j<OnDo_Job.size();j++){
				int temp=(int) OnDo_Job.get(j);
				if(job[temp].getFinish_Time()<=T_now){
					Done_Job.add(temp);
				}
			}
			while(Done_Job.size()>0){
				int min_FinishTime=10000;
				int min_Job=0;
				for(int j=0;j<Done_Job.size();j++){
					int temp=(int) Done_Job.get(j);
					if(job[temp].getFinish_Time()<=min_FinishTime){
						min_FinishTime=job[temp].getFinish_Time();
						min_Job=temp;
					}	
				}
				OnDo_Job.removeElement(min_Job);
				
				if(min_Job!=0){
					if(job[min_Job].getFinish_Time()<=T_now){
						Done_Job.removeElement(min_Job);
System.out.println("Finish::"+job[min_Job].getFinish_Time());
						for(int z=0;z<ServerNumber;z++){
							if(ServerJob.get(z).contains(min_Job)){
								P= (C1 * conf.getCPU_Frequecy()*conf.getCPU_Frequecy()*conf.getCPU_Frequecy() *UtilizationServer[z]+ C2)*CPU_CORE;
								Energy+=(job[min_Job].getFinish_Time()-ServerStartTime[z])*P/3600000;
								ServerStartTime[z]=job[min_Job].getFinish_Time();
							}
							while(ServerJob.get(z).contains(min_Job)){
													
								UtilizationServer[z]-=job[min_Job].getUtilization();
								ActualUtilizationServer[z][0]+=VM[job[min_Job].getVMtype()-1][0];
								ActualUtilizationServer[z][1]+=VM[job[min_Job].getVMtype()-1][1];
								ActualUtilizationServer[z][2]+=VM[job[min_Job].getVMtype()-1][2];
								ServerJob.get(z).removeElement(min_Job);
													
								if(ActualUtilizationServer[z][0]==100&&ActualUtilizationServer[z][1]==100&&ActualUtilizationServer[z][2]==100){//该服务器上的作业全部完成
	
									ServerNumberNow--;
	
									ServerStartTime[z]=0;
									ServerFinishTime[z]=0;
									ServerJob.get(z).clear();
								}
							}							
						}
//System.out.println("E::"+Energy);
//System.out.println("ServerNumberNow::"+ServerNumberNow);
System.out.println();
					}
				}	
			}
			
			int[] flag=new int[ServerNumber];
				for(int p=0;p<ServerNumber;p++){
					flag[p]=0;
				}
			while(vn>0){
				double[][] f=new double[JobNumber+1][ServerNumber];
				int minServer=0;
				double min=100000.0;
				
				for(int y=0;y<ServerNumber;y++){
					if(ActualUtilizationServer[y][0]<100||ActualUtilizationServer[y][1]<100||ActualUtilizationServer[y][2]<100){
						if(ActualUtilizationServer[y][0]>=VM[job[i].getVMtype()-1][0]&&ActualUtilizationServer[y][1]>=VM[job[i].getVMtype()-1][1]&&ActualUtilizationServer[y][2]>=VM[job[i].getVMtype()-1][2]){
							if(job[i].getFinish_Time()<=ServerFinishTime[y]){
								f[i][y]=0;
							}
							else if(job[i].getFinish_Time()>ServerFinishTime[y]){
								f[i][y]=ServerFinishTime[y]-job[i].getArrive_Time();
							}
						}
						else
							continue;
					}
					else if(ActualUtilizationServer[y][0]==100&&ActualUtilizationServer[y][1]==100&&ActualUtilizationServer[y][2]==100){
					
						f[i][y]=job[i].getFinish_Time()-job[i].getArrive_Time();
					}
					else if(ActualUtilizationServer[y][0]<=0||ActualUtilizationServer[y][1]<=0||ActualUtilizationServer[y][2]<=0)
					{	
					
						break;
					}
					if(f[i][y]<min){
						min=f[i][y];
						minServer=y;
					}
				}
				if(ActualUtilizationServer[minServer][0]==100&&ActualUtilizationServer[minServer][1]==100&&ActualUtilizationServer[minServer][2]==100){
					ServerNumberNow++;
					ServerNumberTemp++;
					flag[minServer]=1;
					ServerFinishTime[minServer]=job[i].getFinish_Time();
					ServerStartTime[minServer]=job[i].getArrive_Time();

				}
				else if(ActualUtilizationServer[minServer][0]<100||ActualUtilizationServer[minServer][1]<100||ActualUtilizationServer[minServer][2]<100){
					if(flag[minServer]==0){
						P= (C1 * conf.getCPU_Frequecy()*conf.getCPU_Frequecy()*conf.getCPU_Frequecy() *UtilizationServer[minServer]+ C2)*CPU_CORE;
						Energy+=(job[i].getArrive_Time()-ServerStartTime[minServer])*P/3600000;
						flag[minServer]=1;

						ServerStartTime[minServer]=job[i].getArrive_Time();
					}

					if(job[i].getFinish_Time()>ServerFinishTime[minServer]){
						ServerFinishTime[minServer]=job[i].getFinish_Time();
					}
				}
				UtilizationServer[minServer]+=job[i].getUtilization();
				
				ActualUtilizationServer[minServer][0]-=VM[job[i].getVMtype()-1][0];
				ActualUtilizationServer[minServer][1]-=VM[job[i].getVMtype()-1][1];
				ActualUtilizationServer[minServer][2]-=VM[job[i].getVMtype()-1][2];

				ServerJob.get(minServer).add(i);
System.out.println("Server"+ServerNumberTemp+"  VMtype::"+job[i].getVMtype());
				vn--;
			}
			
//System.out.println("E::"+Energy);
//System.out.println("ServerNumberNow::"+ServerNumberNow);
		}
//System.out.println("All_Energy:"+Energy);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("OTB");
		int JobNumber=conf.getJobNumber();
		OTB(JobNumber);
	}

	

}
