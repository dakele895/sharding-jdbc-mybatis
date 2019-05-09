package com.kl.sharding.util;

/**
 * UUID
 *
 * @author dkl
 * 2019/5/9
 **/
public class UUID {

	public static String getUUID() {
		String id =null;
		java.util.UUID uuid = java.util.UUID.randomUUID();
		id = uuid.toString();

		//去掉随机ID的短横线
		id = id.replace("-", "");

		//将随机ID换成数字
		int num = id.hashCode();
		//去绝对值
		num = num < 0 ? -num : num;

		id = String.valueOf(num);

		return id;
	}

}
