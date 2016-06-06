package yskj.util;
import java.util.Iterator;
import java.util.List;

import yskj.bean.DataBaseConfigInfo;
import yskj.bean.Entity;

public class DBManager extends Base {

	public static List<Entity> compare() {
		
		configInfo = PropertiesXmlFileUtil.readXML("master_database.xml");

		List<Entity> sourceData = DbUtil.select(source_table);
		System.out.println("sourceData.size="+sourceData.size());
		
		configInfo = PropertiesXmlFileUtil.readXML("subordinate_database.xml");


		List<Entity> distData = DbUtil.select(dist_table);
		System.out.println("distData.size="+distData.size());
		for (Iterator<Entity> iter = sourceData.listIterator(); iter.hasNext();) {
			Entity source = iter.next();
			for (Entity dist : distData) {
				if(source.C_ID.equals(dist.C_ID)){
					iter.remove();
					System.out.println("source.C_ID="+source.C_ID);
					System.out.println("dist.C_ID = " + dist.C_ID);
				}
			}
		}

		return sourceData;

	}

	public static void save2DistDB() {
		DbUtil.insert(compare());
	}
	
	
	public static void deleteTempSourceData(){
		DbUtil.delete();
	}

}
