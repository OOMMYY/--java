package greedy;

public class GREEDYKNAPSACK {
	double M;
	double[] P,W;
	int n=6;
	double[] X=new double[n];
	GREEDYKNAPSACK(){
		M=9;
		double[] temp0={10,18,40,56,30,15};
		P=temp0;
		double[] temp1={1,2,5,8,5,3};
		W=temp1;
		X=greedyKnapsack(P,W,M,X,n);
		for(int i=0;i<n;i++){
			System.out.print(X[i]+" ");
		}
	}
	public double[] greedyKnapsack(double[] P,double[] W,double M,double[] X,int n){
		double Cu=M;
		int i;
L1:		for(i=0;i<n;i++){
			if(W[i]>Cu){
				break L1;
			}
			Cu=Cu-W[i];
			X[i]=1;
		}
		if(i<n){
			X[i]=Cu/W[i];
		}
		return X;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GREEDYKNAPSACK();
	}

}
