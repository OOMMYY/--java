package dynamicProgramming;

public class DKNAP {
	double M;
	double[] P,W;
	int n=6;
	int[] X=new int[n+1];
	DKNAP(){
		M=9;
		double[] temp0={0,15,18,40,56,30,10};//本程序P,W以下标从1开始计数
		P=temp0;
		double[] temp1={0,3,2,5,8,5,1};
		W=temp1;
		X=dknap(P,W,M,X,n);
		System.out.println();
		double sum=0;
		System.out.print("X[n]:");
		for(int i=1;i<=n;i++){
			sum+=X[i]*P[i];
			System.out.print(X[i]+" ");
		}
		System.out.println("sum="+sum);
	}
	public int[] dknap(double[] p,double[] w,double M,int[] X,int n){
		int[] F=new int[n+1];
		int m=100;//或者用List存储，list是可变长的。
		double[] P=new double[m];
		double[] W=new double[m];
		double pp,ww;
		int l,h,i,j,k,next,u,v;
		F[0]=1;
		P[1]=W[1]=0;//S0
		System.out.println("S0:");
		System.out.print("("+P[1]+","+W[1]+")");
		l=h=1;//s0的起始和结束位置
		F[1]=next=2;//P和W的第一个空位
		for(i=1;i<n;i++){//生成Si  1~n-1
			k=l;
			for(v=F[i-1];v<F[i];v++){
				if(W[v]+w[i]>M)
					break;
			}
			u=v-1;//在l<=r<=h中使W(v)+W[i]<=M的最大的v;
			System.out.println();
			System.out.println("u:"+u+" (P[u],W[u]):("+P[u]+","+W[u]+")"+" w[i]:"+w[i]);
			System.out.println("S"+i+":");
			for(j=l;j<=u;j++){//生成Si,1及归并
				pp=P[j]+p[i];
				ww=W[j]+w[i];//Si,i的下一个元素
				while (k<=h&&W[k]<ww){//从Si-1中取元素来归并
					P[next]=P[k];
					W[next]=W[k];
					System.out.print("("+P[k]+','+W[k]+") ");
					next++;
					k++;
				}
				if(k<=h&&W[k]==ww){//
					pp=max(pp,P[k]);
					k++;
				}
				if(pp>P[next-1]){//Si-1中最后一个序偶（P[next-1],W[next-1]）,如果P[next-1]>=pp,则舍弃（pp,ww）
					P[next]=pp;
					W[next]=ww;
					next++;
					System.out.print("("+pp+','+ww+") ");
				}
				while(k<=h&&P[k]<=P[next-1]){//清除
					k++;
				}
			}
				//将Si-1中剩余元素并入Si//
				while(k<=h){
					P[next]=P[k];
					W[next]=W[k];
					System.out.print("("+P[k]+','+W[k]+") ");
					next++;
					k++;
				}
				//对Si+1置初值//
				l=h+1;
				h=next-1;
				F[i+1]=next;	
		}
		double Px=P[next-1];
		double Wx=W[next-1];
		double Wl=0;
		double Pl=0;
		for(i=F[n-1];i<F[n]&&W[i]+w[n]<M;i++){
			if(W[i]>Wl){
				Wl=W[i];
				Pl=P[i];
			}
		}
		double Py=Pl+p[n];
		double Wy=Wl+w[n];
		if(Px>Py){
			X[n]=0;
			
		}
		else{
			X[n]=1;
			Px=Pl;
			Wx=Wl;
		}
		for(k=n-1;k>0;k--){
		boolean flag=false;
		for(i=F[k-1];i<F[k];i++){
			if(P[i]==Px&&W[i]==Wx){
				flag=true;
				break;
			}
		}
		if(!flag){
			X[k]=1;
			Px=Px-p[k];
			Wx=Wx-w[k];
		}
		}
		return X;
	}
	public double max(double a,double b){
		if(a>=b)
			return a;
		else
			return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DKNAP();
	}

}
