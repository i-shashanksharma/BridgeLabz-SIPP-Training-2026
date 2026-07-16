import java.util.*;

class BankFraudDetection {
    static long merge(int[] a, int l, int m, int r) {
        long count = 0;
        int j = m + 1;

        for (int i = l; i <= m; i++) {
            while (j <= r && a[i] > 3L * a[j])
                j++;
            count += j - (m + 1);
        }

        int[] temp = new int[r-l+1];
        int i=l,k=0;
        j=m+1;

        while(i<=m && j<=r)
            temp[k++]=a[i]<=a[j]?a[i++]:a[j++];

        while(i<=m) temp[k++]=a[i++];
        while(j<=r) temp[k++]=a[j++];

        for(i=l;i<=r;i++) a[i]=temp[i-l];

        return count;
    }

    static long sort(int[] a,int l,int r){
        if(l>=r) return 0;
        int m=(l+r)/2;
        return sort(a,l,m)+sort(a,m+1,r)+merge(a,l,m,r);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];

        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

        System.out.print(sort(a,0,n-1));
    }
}