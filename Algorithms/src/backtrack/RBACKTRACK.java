package backtrack;

/*	回溯法求n皇后问题
 * 	先以4皇后为例，最后求出的解空间存在一个数组x[4]中
 * 	要解决皇后问题还得编制一个限界函数place();
*/
public class RBACKTRACK {
	static int n=4;//这里可以修改皇后数目
	static int[] x=new int[n];//存储解空间	 	
	public RBACKTRACK(){ 
		int k=0;

		rbacktrack(k);
	}
	public static void rbacktrack(int k){
		if(k==n){//递归出口
			for(int i=0;i<n;i++){
				System.out.print(x[i]+"  ");
			}
			System.out.println();
			return;
		}
		x[k]=0;//记得清零
		while(x[k]<n){//记得在这里加while循环,这样才能够不断增加问题空间
			if(place(k))
				rbacktrack(k+1);
			x[k]++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RBACKTRACK rb=new RBACKTRACK();
	}
	public static boolean place(int k){
		int i=0;
		while(i<k){
			if(x[i]==x[k]||Math.abs(x[i]-x[k])==Math.abs(i-k)){
				return false;
			}
			i=i+1;
		}
		return true;
	}

}
