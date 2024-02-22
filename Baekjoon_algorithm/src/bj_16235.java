import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_16235 {
	static int dx[] = {1,1,1,-1,-1,-1,0,0};
	static int dy[] = {1,-1,0,1,-1,0,1,-1};
	static int n,m,k;
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static PriorityQueue<Tree> die = new PriorityQueue<>();
	static int energy[][];
	static int w[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		energy = new int[n][n];
		w = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
				energy[i][j] = 5;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x,y,age));
		}
		
		for(int i=0;i<k;i++) {
			spring();
			fall();

		}
		int ans =0;
		System.out.println(pq.size());

	}
	private static void fall() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				energy[i][j] += w[i][j];
			}
		}
	}

	private static void spring() {
		PriorityQueue<Tree> pq2 = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			Tree tree = pq.poll();
			int x = tree.r;
			int y = tree.c;
			int age = tree.age;
			if(energy[x][y] < age) {
				die.add(new Tree(x,y,age/2));
			}
			else {
				energy[x][y] -= age;

				pq2.add(new Tree(x,y,age+1));
			}
		}
		for(Tree t:die) {

			energy[t.r][t.c] += t.age;
		}
		die.clear();


		while(!pq2.isEmpty()) {
			Tree tree = pq2.poll();
			int x = tree.r;
			int y = tree.c;
			int age = tree.age;
			pq.add(new Tree(x,y,age));
			if(age % 5 ==0) {
				for(int z =0;z<8;z++) {
					int nx = dx[z]+x;
					int ny = dy[z]+y;
					if(nx<0||ny<0||nx>=n||ny>=n) continue;
					pq.add(new Tree(nx,ny,1));
				}
			}
		}

		
	}
	static class Tree implements Comparable<Tree> {
	    int r, c, age;
	    
	    Tree(int r, int c, int age) {
	        this.r = r;
	        this.c = c;
	        this.age = age;
	    }
	    
	    public int compareTo(Tree t) {
	    	return Integer.compare(this.age, t.age);
	    }
	}

}
