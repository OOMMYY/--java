package backtrack;

/*	���ݷ���n�ʺ�����
 * 	����4�ʺ�Ϊ�����������Ľ�ռ����һ������x[4]��
 * 	Ҫ����ʺ����⻹�ñ���һ���޽纯��place();
*/
public class BACKTRACK {
	static int n=8;//��������޸Ļʺ���Ŀ
	static int[] x=new int[n];//�洢��ռ�   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		x[0]=0;//��0���ʺ���ڵ�0��
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
				k=k-1;//����
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
