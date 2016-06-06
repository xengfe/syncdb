package yskj.main;

import java.util.Timer;
import java.util.TimerTask;



import yskj.util.DBManager;

public class SyncDB {

	public static void main(String[] args) {
		int delay = 0;//毫秒
		int period = 10 * 1000;//10s
		
		Timer timer = new Timer(); 
		TimerTask task = new TimerTask (){

			@Override
			public void run() {
				long beginTime = System.currentTimeMillis();
				DBManager.save2DistDB();
//				DBManager.deleteTempSourceData();
				long endTime =System.currentTimeMillis();
				System.out.println("操作时长：" + (endTime - beginTime) +" 毫秒");
				
			}
			
		};
		timer.schedule(task, delay,period) ;
		
		
		
	}

}
