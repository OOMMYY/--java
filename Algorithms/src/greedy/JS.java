package greedy;

public class JS {
	int n=7;
	int [] D={0,2,3,1,3,4,5,2};//�±��1��ʼ
	float[] P={0,15,12,11,10,8,5,4};//�ȶ�P���з�������
	int[] J=new int[n+1]; 
	int k;
	JS(){
		k=js(D,J,n,k);
		System.out.println("�ɵ�����ҵ��Ŀ:"+k);
		double sum=0;
		System.out.print("��ҵ���ȴ���"); 
		for(int i=1;i<=k;i++){
			System.out.print("->"+J[i]);
			sum+=P[J[i]];
		}
		System.out.println();
		System.out.println("������Sum="+sum);
	}
	public int js(int[] D,int[] J,int n,int k){
		int i,r;
		k=1;
		J[1]=1;//�ѵ�һ����ҵ����
		for(i=2;i<n;i++){
			r=k;
			while(D[J[r]]>D[i]&&D[J[r]]!=r){
				r--;
			}
			if(D[J[r]]<=D[i]&&D[i]>r){
				for(int l=k;l>r;l--){
					J[l+1]=J[l];
				}
				J[r+1]=i;
				k++;
			}
		}
		return k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JS();
	}

}