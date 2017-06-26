package cn.zaysx.util;

import java.util.UUID;

public class UUIDUtil {
	
	/**
	 * 获得UUID
	 * @return
	 */
	public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
