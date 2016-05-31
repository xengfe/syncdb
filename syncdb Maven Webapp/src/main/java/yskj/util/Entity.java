package yskj.util;

import java.sql.Timestamp;

public class Entity {
	
	public String C_ID;
	public String C_UID;
	public long C_DSYNC;
	public Timestamp C_TIME;
	public double C_GLU;
	public short C_FLAG;
	public short C_RES;
	public short C_CTYPE;
	public short C_UPLOAD;
	public Timestamp C_CreateTime;
	public String C_ClientIP;
	public Entity(String c_ID, String c_UID, long c_DSYNC, Timestamp c_TIME,
			double c_GLU, short c_FLAG, short c_RES, short c_CTYPE,
			short c_UPLOAD, Timestamp c_CreateTime, String c_ClientIP) {
		super();
		C_ID = c_ID;
		C_UID = c_UID;
		C_DSYNC = c_DSYNC;
		C_TIME = c_TIME;
		C_GLU = c_GLU;
		C_FLAG = c_FLAG;
		C_RES = c_RES;
		C_CTYPE = c_CTYPE;
		C_UPLOAD = c_UPLOAD;
		C_CreateTime = c_CreateTime;
		C_ClientIP = c_ClientIP;
	}
	
	
	

}
