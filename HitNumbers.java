package com.datamining.frequentpath.helper;

import java.io.*;

import java.util.*;



public class HitNumbers
{


int count_path=0;

List<Integer> Largest_path_numbers=null;
HitNumberLargestPath hnlp=null;


	public List getHitNumbersLargestpath()
		{

			System.out.println("HI IAM IN HIT NUMBERS CLASS **********************************");

			Largest_path_numbers=new LinkedList<Integer>();
			System.out.println("HI IAM IN HIT NUMBERS CLASS created list **********************************");

			hnlp=new HitNumberLargestPath();
			
			System.out.println("The hit number largest path object  is  **********************************"+hnlp);

			count_path=hnlp.getLargestPathHitNumber("one");

			Largest_path_numbers.add(0,count_path);

			System.out.println("hi i got hitnumberof first path**************************"+count_path);

			count_path=hnlp.getLargestPathHitNumber("two");

			Largest_path_numbers.add(1,count_path);
			
			System.out.println("hi i got hitnumberof second path**************************"+count_path);

			return Largest_path_numbers;

		}


}
