//Set the general configuration in this class
//We should set: 1. the configuration of VM
//				 2. the Server CPU, Mem, Sto
//				 3. the species of VM
//				 4. the energy function C1, C2, CPU_CORE
//				 5. the max CPU frequency
//				 6. the number of Job
//				 7. the number of Server

public class DcConfiguration {
	private int[][] VM_conf;
	private int S_CPU;
	private int S_Mem;
	private int S_Sto;
	private double[][] VM;
	private int VMTYPE;
	private double C1;
	private double C2;
	private int CPU_CORE;
	private int JobNumber;
	private int ServerNumber;
	private double CPU_Frequency;
	
	public double getCPU_Frequecy(){
		return CPU_Frequency;
	}
	
	public int getServerNumber(){
		return ServerNumber;
	}
	
	public int[][] getVM_conf() {
		return VM_conf;
	}

	public int getS_CPU() {
		return S_CPU;
	}

	public int getS_Mem() {
		return S_Mem;
	}

	public int getS_Sto() {
		return S_Sto;
	}

	public double[][] getVM() {
		return VM;
	}

	public int getVMTYPE() {
		return VMTYPE;
	}

	public double getC1() {
		return C1;
	}

	public double getC2() {
		return C2;
	}

	public int getCPU_CORE() {
		return CPU_CORE;
	}

	public int getJobNumber() {
		return JobNumber;
	}
	
	public DcConfiguration(){
		VM_conf= new int[][]{{1,1,100},{2,1,200},{1,2,200},{2,3,100}};
		S_CPU=4;
		S_Mem=6;
		S_Sto=600;
		VMTYPE=4;
		C1=0.8622;
		C2=18.905;
		CPU_CORE=4;
		JobNumber=11;
		ServerNumber=1000;
		CPU_Frequency=2.66;
		VM= new double[VM_conf.length][3];
		for(int i=0;i<VM_conf.length;i++){
			for(int j=0;j<3;j++){
				if(j==0){
					VM[i][0]=Math.ceil((double)100*(double)VM_conf[i][0]/(double)S_CPU);
				}
				else if(j==1){
					VM[i][1]=Math.ceil((double)100*(double)VM_conf[i][1]/(double)S_Mem);
				}
				else if(j==2){
					VM[i][2]=Math.ceil((double)100*(double)VM_conf[i][2]/(double)S_Sto);
				}
			}
		}
	}

}
