package divideAndConquer;

import java.lang.reflect.Array;

public class MERGE {
	int[] a={2,4,67,8,98,44,2,344,43,3,4,4,3,4,3};
	int n=Array.getLength(a);
	MERGE(){
		danc(0,n-1);
		//selectSort(0,n-1);
		System.out.print("分治法排序结果：");
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
	}
	public void danc(int low,int high){
		int mid=(low+high)/2;
		if(high-low<5){
			selectSort(low,high);
			return;	
		}
		danc(low,mid);
		danc(mid+1,high);
		merge(low,mid,high);

	}
	public void selectSort(int low,int high){
		int temp;
		for(int i=low+1;i<=high;i++){
			temp=a[i];
			int j=i;
			while(temp<a[j-1]&&j>low){//这里一定要加上  j>low 防止越界
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
	}
	public void merge(int low,int mid,int high){
		int[] b=new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=high){
			if(a[i]<=a[j]){
				b[k]=a[i];
				i++;
				k++;
			}else{
				b[k]=a[j];
				j++;
				k++;
			}
		}
		if(i<=mid){
			for(;i<=mid;i++){
				b[k]=a[i];
				k++;
			}
		}else
			for(;j<=high;j++){
				b[k]=a[j];
				k++;
			}
		for(i=0;i<high-low+1;i++){
			a[low+i]=b[i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MERGE();
	}

}
