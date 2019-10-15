package com.bawei;

import java.io.IOException;

import com.mmcro.common.FileUtil;

public class test {

	public static void main(String[] args) throws IOException {

//		String str = "123";
//		str = str + "\n" + "abc";
//		
//		String[] split = str.split("\n");
//		System.out.println(Integer.parseInt(split[0]));

		String string = FileUtil.readFile("123.txt");

		String[] split = string.split("\n");

		for (String str : split) {
			String[] split2 = str.split(",");
			System.out.println(Integer.parseInt(split2[0]));
		}

	}

}
