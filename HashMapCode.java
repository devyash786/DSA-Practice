package com.dev.dsa;

import java.util.*;

public class HashMapCode {
	static class HashMap<K, V> {
		public class Node {
			K key;
			V value;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int n;// for nodes
		private int N;// buckets
		private LinkedList<Node> buckets[];

		public HashMap() {
			this.N = 4;
			this.buckets = new LinkedList[4];

			for (int i = 0; i < 4; i++) {
				this.buckets[i] = new LinkedList<>();
			}
		}

		public int hashFunction(K key) {
			int bi = key.hashCode();
			return Math.abs(bi) % N;
		}

		public int searchInLL(K key, int bi) {
			LinkedList<Node> ll = buckets[bi];

			for (int i = 0; i < ll.size(); i++) {
				if (ll.get(i).key == key) {
					return i;
				}
			}
			return -1;
		}

		public void rehash() {
			LinkedList<Node> oldBucket[] = buckets;
			buckets = new LinkedList[N * 2];

			for (int i = 0; i < N * 2; i++) {
				buckets[i] = new LinkedList<>();

			}

			for (int bi = 0; bi < oldBucket.length; bi++) {
				LinkedList<Node> ll = oldBucket[bi];
				for (int di = 0; di < ll.size(); di++) {
					Node node = ll.get(di);
					put(node.key, node.value);
				}
			}
		}

		public void put(K key, V value) {
			int bi = hashFunction(key);
			System.out.println(key + " "+bi);
			int di = searchInLL(key, bi);
			System.out.println(key + " "+di);
			if (di == -1) {
				buckets[bi].add(new Node(key, value));
				n++;
			} else {
				Node node = buckets[bi].get(di);
				node.value = value;
			}

			double lambda = (double) n / N;
			if (lambda > 2.0) {
				rehash();
			}
		}

		public boolean containsKey(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			if (di == -1) {
				return false;
			} else {
				return true;
			}

		}

		public V remove(K key) {
			
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			if (di == -1) {
				return null;
			} else {
				Node node = buckets[bi].remove(di);
				n--;
				return node.value ;
			}

		}

		public V get(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key, bi);

			if (di == -1) {
				return null;
			} else {
				Node node = buckets[bi].get(di);
				return node.value ;
			}
		}
		public ArrayList<K> keySet() {
			ArrayList<K> arrayList= new ArrayList<>();
			
			for(int i=0;i<buckets.length;i++) {
				LinkedList<Node> ll = buckets[i];
				for(int j=0;j<ll.size();j++) {
					arrayList.add(ll.get(j).key);
				}
			}
			return arrayList;
			
			}
		public boolean isEmpty() {
			return n==0;
			}
		
		public static void main(String[] args) {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("India", 190);
			map.put("China", 200);
			map.put("US", 50);
			
			ArrayList<String> keys = map.keySet();
			
			System.out.println(keys);
			for(int i=0; i<keys.size(); i++) {
			System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
			}

//			map.remove("India");
//			System.out.println(map.get("India"));

		}
	}

	

}
