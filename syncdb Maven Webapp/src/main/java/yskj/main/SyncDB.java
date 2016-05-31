package yskj.main;

import yskj.util.DBManager;

public class SyncDB {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true){
						System.out.println("线程启动...");
						DBManager.save2DistDB();
						Thread.sleep(60*1000*2);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	

	}

}
