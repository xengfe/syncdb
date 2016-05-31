package yskj.util;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends Base {

	public static List<Entity> compare() {
		List<Entity> avalbleEntities = new ArrayList<Entity>();

		URL = "";
		USER = "";
		PWD = "";

		List<Entity> sourceData = DbUtil.select(source_table);

		URL = "";
		USER = "";
		PWD = "";

		List<Entity> distData = DbUtil.select(dist_table);

		for (int i = 0; i < sourceData.size(); i++) {
			for (int j = 0; j < distData.size(); j++) {
				if (!sourceData.get(i).C_ID.equals(distData.get(j).C_ID)) {
					avalbleEntities.add(sourceData.get(i));
				}
			}

		}
		return avalbleEntities;

	}

	public static void save2DistDB() {
		DbUtil.insert(compare());
	}

}
