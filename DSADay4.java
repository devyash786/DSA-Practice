package com.dev.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

import com.dev.dsa.HashMapCode.HashMap;

public class DSADay4 {
  static class HasMapDev<K,V>{
	  public class Node{
		  K key;
		  V value;
		  
		public Node(K key, V value) {
			this.key=key;
			this.value=value;
		}
		  
	  }
	  private int n;//nodes
	  private int N;//buckets
	  LinkedList<Node> buckets[];
	  public HasMapDev() {
		  this.N=4;
		  this.buckets=new LinkedList[4];
		  
		  for(int i=0;i<4;i++) {
			  this.buckets[i]=new LinkedList();
		  }
	  }
	  
	  private int hashFunction(K key) {
		  int bi=key.hashCode();
		  return Math.abs(bi) % N;
	  }
	  private int searchInLL(K key, int bi) {
		LinkedList<Node> node=buckets[bi];
		for(int i=0;i<node.size();i++) {
			if(node.get(i).key==key) {
				return i;
			}
		}
		return -1;
	  }
	  private void reshashe() {
		  LinkedList<Node> oldBucket[]= buckets;
		  buckets= new LinkedList[2*N];
		  
		  for(int i=0;i<2*N;i++) {
			  buckets[i]= new LinkedList<>();
		  }
		  
		  for(int i=0;i<oldBucket.length;i++) {
			  LinkedList<Node> ll  = oldBucket[i];
			  for(int j=0;j<ll.size();j++) {
				  Node node= ll.get(i);
				  put(node.key,node.value);
			  }
		  }
	  }
	  private void put(K key, V value) {
		  int bi=hashFunction(key);
		  int di=searchInLL(key,bi);
		  
		  if(di==-1) {
			  buckets[bi].add(new Node(key,value));
			  n++;
		  }
		  else {
			  Node node= buckets[bi].get(di);
			  node.value=value;
		  }
		  
		  double lambda=(double)n/N;
		  if(lambda>2.0) {
			  reshashe();
		  }
	  }
	  private boolean containsKey(K key) {
		  int bi=hashFunction(key);
		  int di=searchInLL(key,bi);
		  
		  if(di==-1) {
			  return false;
		  }
		  else {
			  return true;
		  }
	  }
	  private V get(K key) {
		  int bi=hashFunction(key);
		  int di=searchInLL(key,bi);
		  
		  if(di==-1) {
			  return null;
		  }
		  else {
			 Node node= buckets[bi].get(di);
			 return node.value;
		  }
	  }
	  private ArrayList<K> keySet(){
		  ArrayList<K> arrayList = new ArrayList<>();
		  
		  for(int i=0;i<buckets.length;i++) {
			  LinkedList<Node> ll  = buckets[i];
			  for(int j=0;j<ll.size();j++) {
				  Node node= ll.get(j);
				 arrayList.add(node.key);
			  }
		  }
		  
		  return arrayList;
		  
		  
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HasMapDev<String, Integer> map = new HasMapDev<>();
		map.put("India", 190);
		map.put("China", 200);
		map.put("US", 50);
		
		ArrayList<String> keys = map.keySet();
		
		System.out.println(keys);
		System.out.println(map.toString());
		for(int i=0; i<keys.size(); i++) {
		System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
		}
	}

}
