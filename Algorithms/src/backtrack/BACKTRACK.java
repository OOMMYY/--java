package backtrack;

/*	回溯法求n皇后问题
 * 	先以4皇后为例，最后求出的解空间存在一个数组x[4]中
 * 	要解决皇后问题还得编制一个限界函数place();
*/
public class BACKTRACK {
	static int n=8;//这里可以修改皇后数目
	static int[] x=new int[n];//存储解空间   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		x[0]=0;//第0个皇后放在第0列
		int k=0;
		while (k>=0){
			x[k]=x[k]+1;
			while(x[k]<n&&!place(k)){
				x[k]=x[k]+1;
			}
			if(x[k]<n){
				 if(k==n-1){
					 System.out.println();
					 for(int i=0;i<n;i++){
						 System.out.print(x[i]+" ");
					 }
					// return;
				 }else{
					 k=k+1;
					 x[k]=-1;
				 } 
			}
			else{
				k=k-1;//回溯
			}
			}
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
