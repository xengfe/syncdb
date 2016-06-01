package yskj.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DBManager extends Base {

	public static List<Entity> compare() {
		
		URL = "jdbc:mysql://localhost/idevicecloud";
		USER = "root";
		PWD = "123456";

		List<Entity> sourceData = DbUtil.select(source_table);

		URL = "jdbc:mysql://localhost/imobilecloud";
		USER = "root";
		PWD = "123456";

		List<Entity> distData = DbUtil.select(dist_table);
		
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

}
