package sort;

import java.util.Arrays;


public class MergeSort {
    static int[] sorted = new int[8];
    public static void merge(int a[], int m, int middle, int n) {
        int i = m;             // 첫 번째 부분집합의 시작 위치 설정
        int j = middle+1;     // 두 번째 부분집합의 시작 위치 설정
        int k = m;             // 배열 sorted에 정렬된 원소를 저장할 위치 설정
        System.out.printf("i:%d j:%d k:%d\n",i,j,k);
        while(i<=middle && j<=n) {
            if(a[i]<=a[j]) {
                sorted[k] = a[i];
                i++;
            }else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        if(i>middle) { //남은 인덱스 채우기 
            for(int t=j;t<=n;t++,k++) {
                sorted[k] = a[t];
            }
        }else {
            for(int t=i;t<=middle;t++,k++) {
                sorted[k] = a[t];
            }
        }
        
        for(int t=m;t<=n;t++) { //배열 옮기기 
            a[t] = sorted[t];
        }
        System.out.println("병합 정렬 후: "+Arrays.toString(a));
    }
        
    
    public static void mergeSort(int a[], int m, int n) {
        int middle;
        if(m<n) {
            middle = (m+n)/2;
            System.out.printf("앞 mergeSort(a, %d, %d)\n",m,middle);
            mergeSort(a, m, middle);    // 앞 부분에 대한 분할 작업 수행
            System.out.printf("뒤 mergeSort(a, %d, %d)\n",middle+1,n);

            
            mergeSort(a, middle+1, n);    // 뒷 부분에 대한 분할 작업 수행
            System.out.printf("병합 merge(a, %d, %d, %d)\n",m,middle,n);

            merge(a, m, middle, n);        // 부분집합에 대하여 정렬과 병합 작업 수행
        }
    }
    public static void main(String[] args) {
        int[] list = {58,8,28,3,18,6,33,20};
        int size = list.length;
        System.out.println("정렬 수행 전: "+Arrays.toString(list));
        System.out.println("-----------------병합 정렬 수행 시작------------------");
        mergeSort(list, 0, size-1);
//        int a = 3;
//        System.out.printf("hello%d\n",a);
    }
 
}
 