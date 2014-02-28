package com.lenovo.newThink.util;

import java.util.List;

import com.lenovo.newThink.vo.NewObjectiveVo;

public class ObjectiveProcessUtil {
	public static String ObjProcessCount(List<NewObjectiveVo> list) {
		int totalNo = 0;
		int complecatedNo = 0;
		String result = "";
		if (list != null) {
			totalNo = list.size();
			for (NewObjectiveVo it : list) {
				if (it.getStatus().equals("true1"))
					complecatedNo++;
			}
		}
		result = complecatedNo + "/" + totalNo;
		return String.valueOf(result);
	}
}