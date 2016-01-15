package dynamicProgramming;

public class BGRAPH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		int first[],next[];
		int n=12;
		int m=21;
		int[] u={0,1,1,1,1,2,2,2,3,3,4,5,5,6,6,7,7,8,8,9,10,11};
		int[] v={0,2,3,4,5,6,7,8,6,7,8,7,8,9,10,9,10,10,11,12,12,12};
		int[] w={0,9,7,3,2,4,2,1,2,7,11,11,8,6,5,4,3,5,6,4,2,5};
		first=new int[n+1];
		next=new int[m+1];
		for(i=1;i<n+1;i++)
			first[i]=-1;
		for(i=1;i<m+1;i++){
			next[i]=first[u[i]];
			first[u[i]]=i;
			System.out.println(i+" u,v,w: "+u[i]+" "+v[i]+"  "+w[i]);
		}
		//±éÀú
		int k;
		int[] cost=new int[n+1];
		int[] d=new int[n+1];
		for(i=1;i<n+1;i++){
			cost[i]=9999;
			d[i]=-1;
		}
		cost[1]=0;
		for(i=1;i<n+1;i++){
			k=first[i];
			while(k!=-1){
				if(w[k]+cost[u[k]]<cost[v[k]]){
					cost[v[k]]=w[k]+cost[u[k]];
					d[v[k]]=u[k];
				}
				k=next[k];
			}	
		}
		i=12;
		System.out.println();
		System.out.print("12");
		while(d[i]!=-1){
			System.out.print(" <-- "+d[i]);
			d[i]=d[d[i]];
		}
		System.out.println("    cost[1]:"+cost[12]);
	}

}
