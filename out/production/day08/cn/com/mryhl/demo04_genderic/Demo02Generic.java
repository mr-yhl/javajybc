// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo02Generic.java

package cn.com.mryhl.demo04_genderic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo02Generic
{

	public Demo02Generic()
	{
	}

	public static void main(String args[])
	{
		ArrayList list2 = new ArrayList();
		list2.add("hello");
		list2.add("world");
		list2.add("java");
		String s1;
		for (Iterator iterator = list2.iterator(); iterator.hasNext(); System.out.println(s1))
			s1 = (String)iterator.next();

	}
}
