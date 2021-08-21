package recurtion;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	private static int m=3;
	private static int n=3;
	static int[][] a= {
			{1,0,0},
			{1,1,1},
			{1,1,1}};
	private static int[][] visited=new int[m][n];
	static List<Character> possible=new ArrayList<>(List.of('D','R','U','L'));
	static List<Integer> fori=new ArrayList<>(List.of(1,0,-1,0));
	static List<Integer> forj=new ArrayList<>(List.of(0,1,0,-1));
	public static int count(int ind,int sum,int arr[],int n,List<Integer> res)
	{
		if(ind==n)
		{
			if(sum==0) {
				System.out.println(res);
				return 1;
			}
			else {
				return 0;
			}
		}
		int left=0;
		int right=0;
		if(arr[ind]<=sum) {
			res.add(arr[ind]);
			sum-=arr[ind];
			//For repetation use ind for not repetative result use ind+1
			left=count(ind+1,sum,arr,n,res);
			sum+=arr[ind];
			res.remove(Integer.valueOf(arr[ind]));
		}
		right=count(ind+1,sum,arr,n,res);
		return left+right;

	}

	public static void path(int i,int j,List<Character> path)
	{


		if(i==m || j==n)
			return ;
		if(i==m-1 && j==n-1) {
			System.out.println(path);
			return ;
		}
		path.add('D');
		path(i+1,j,path);
		path.remove(path.size()-1);
		path.add('R');
		path(i,j+1,path);
		path.remove(path.size()-1);

	}
	
	public static void pathFour(int i,int j,List<Character> path)
	{


		if(i==m || j==n || i<0 || j<0 || visited[i][j]==1 || a[i][j]==0)
			return ;
		if(i==m-1 && j==n-1) {
			System.out.println(path);
			return ;
		}
		visited[i][j]=1;
		for(int k=0;k<possible.size();k++)
		{
			path.add(possible.get(k));
			pathFour(i+fori.get(k),j+forj.get(k),path);
			path.remove(path.size()-1);
		}
		visited[i][j]=0;
	}
	public static void main(String[] args) 
	{
		//possible subsets sum equal to sum 
		int[] arr={1,2,3,4};
		List<Integer> res=new ArrayList<>();
		System.out.println(count(0,4,new int[] {1,2,3,4},4,res));
		List<Character> path=new ArrayList<Character>();
		//possible paths that reach the destination
		path(0,0,path);
		path.clear();
		System.out.println("\n");
		//printing possible ways in four directions and also only through 1 s
		pathFour(0,0,path);
		

	}

}
