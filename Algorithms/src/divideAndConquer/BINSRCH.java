package divideAndConquer;

public class BINSRCH {
	int j=-1;
	BINSRCH(){
		int[] a={4,7,3,1,5,6,0,8,9,2};
		binsrch(a,10,5);//binsrch(a,10,5,j),���������ԣ�java����������ֻ�����ã������ı���������������濴�����仯
		System.out.println(j);
	}
	public void binsrch(int[] A,int n,int x){
		int low,high,mid;
		low=0;
		high=n-1;
		while(low<=high){
			mid=(low+high)/2;
			if(A[mid]==x){
				j=mid;
				return;
			}
			else{
				if(A[mid]<x){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BINSRCH();
	}

}
