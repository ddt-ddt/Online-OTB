//Set the Job in this class
//We should set: 1. the VM type of this job
//				 2. the time of Map task
//				 3. the time of Reduce task
//				 4. the number of Map task
//				 5. the number of Reduce task
//				 6. the requirement of VM number
//				 7. the configuration of Map slot in virtual cluster
//				 8. the configuration of Reduce slot in virtual cluster
//				 9. the arriving time of job

public class JobConfiguration {
	static DcConfiguration conf=new DcConfiguration();
	private double[][] VM = conf.getVM();
	private int VMtype;//VM type
	private int tm;//Map time
	private int tr;//Reduce time
	private int mNum;//Map number
	private int rNum;//Reduce number
	private int mSlot;//Map slot
	private int rSlot;//Reduce slot
	private int vn;//Require VM number
	private double T;
	private int Arrive_Time;//arrrive time
	private int Finish_Time;//finish time
	private double utilization;//cpu utilization
	
	public int getVMtype() {
		return VMtype;
	}
	public int getTm() {
		return tm;
	}
	public int getTr() {
		return tr;
	}
	public int getmNum() {
		return mNum;
	}
	public int getrNum() {
		return rNum;
	}
	public int getmSlot() {
		return mSlot;
	}
	public int getrSlot() {
		return rSlot;
	}
	public int getVn() {
		return vn;
	}
	public double getT(){
		return T;
	}
	public double getUtilization() {
		return utilization;
	}
	public int getArrive_Time() {
		return Arrive_Time;
	}
	public int getFinish_Time() {
		return Finish_Time;
	}
	
	public JobConfiguration(int i){
		if(i==1){
			VMtype=4;
			tm=60;
			tr=2463;
			mNum=458;
			rNum=1;
			mSlot=4;
			rSlot=1;
			vn=6;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=1;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==2){
			VMtype=4;
			tm=60;
			tr=2463;
			mNum=458;
			rNum=1;
			mSlot=4;
			rSlot=1;
			vn=6;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=500;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==3){
			VMtype=3;
			tm=39;
			tr=384;
			mNum=102;
			rNum=1;
			mSlot=2;
			rSlot=1;
			vn=3;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=1000;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==4){
			VMtype=3;
			tm=39;
			tr=384;
			mNum=102;
			rNum=1;
			mSlot=2;
			rSlot=1;
			vn=3;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=1500;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		
		else if(i==5){
			VMtype=1;
			tm=30;
			tr=2400;
			mNum=160;
			rNum=2;
			mSlot=2;
			rSlot=1;
			vn=7;
			T=(double) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=2000;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==6){
			VMtype=3;
			tm=39;
			tr=384;
			mNum=102;
			rNum=1;
			mSlot=2;
			rSlot=1;
			vn=3;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=2500;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==7){
			VMtype=3;
			tm=39;
			tr=384;
			mNum=102;
			rNum=1;
			mSlot=2;
			rSlot=1;
			vn=3;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=3000;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==8){
			VMtype=4;
			tm=60;
			tr=2463;
			mNum=458;
			rNum=1;
			mSlot=4;
			rSlot=1;
			vn=6;
			T=(int) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=3500;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==9){
			VMtype=1;
			tm=30;
			tr=2400;
			mNum=160;
			rNum=2;
			mSlot=2;
			rSlot=1;
			vn=7;
			T=(double) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=4000;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==10){
			VMtype=1;
			tm=30;
			tr=2400;
			mNum=160;
			rNum=2;
			mSlot=2;
			rSlot=1;
			vn=7;
			T=(double) (tm*Math.ceil(mNum/(mSlot*vn))+tr*Math.ceil(rNum/(rSlot*vn)));
			Arrive_Time=4500;
			utilization = ((double)VM[VMtype-1][0])/100;
			Finish_Time=Arrive_Time+(int)T;
		}
		else if(i==11){
			Arrive_Time=100000;
		}
	}

}
