package java_base;
/**
 * 
 * @author chenyanqiu
 */
public class Test {

	public static void main(String[] args) {
		int[] a={24,12,45,45,33};
		Test.selectSort(a);
	}
	//选择排序算法
	static void selectSort(int[] a){
		int temp,index = 0;
		for(int i=0;i<a.length-1;i++){
			index=i;
			for(int j= i+1;j<a.length;j++){
				if (a[j]<a[index]) {
					index=j;
				}
				
			}
			if (index!=i) {
				temp=a[i];
				a[i]=a[index];
				a[index]=temp;
			}
			
		}
		for (int h = 0; h < a.length; h++) {
			System.out.println(" "+a[h]);
		}
		
	}

}
