package backtrack;

/*	���ݷ���n�ʺ�����
 * 	����4�ʺ�Ϊ�����������Ľ�ռ����һ������x[4]��
 * 	Ҫ����ʺ����⻹�ñ���һ���޽纯��place();
*/
public class RBACKTRACK {
	static int n=4;//��������޸Ļʺ���Ŀ
	static int[] x=new int[n];//�洢��ռ�	 	
	public RBACKTRACK(){ 
		int k=0;

		rbacktrack(k);
	}
	public static void rbacktrack(int k){
		if(k==n){//�ݹ����
			for(int i=0;i<n;i++){
				System.out.print(x[i]+"  ");
			}
			System.out.println();
			return;
		}
		x[k]=0;//�ǵ�����
		while(x[k]<n){//�ǵ��������whileѭ��,�������ܹ�������������ռ�
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
