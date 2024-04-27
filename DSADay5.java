package com.dev.dsa;

import java.util.HashSet;

public class DSADay5 {
	public static void unionArray(int arr1[],int arr2[]) {
		HashSet<Integer> hashSet = new HashSet<>();
		for(int n:arr1) {
			hashSet.add(n);
		}
		for(int n:arr2) {
			hashSet.add(n);
		}
		System.out.println(hashSet.size());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {7,3,9};
		int arr2[]= {6,3,2,9,1,7};
		unionArray(arr1,arr2);
	}

}
