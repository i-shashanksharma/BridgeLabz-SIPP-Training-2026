import java.util.*;

class WebsiteResponseAnalysis {
    static long merge(int[] a,int l,int m,int r){
        long count=0;
        int[] t=new int[r-l+1];
        int i=l,j=m+1,k=0;

        while(i<=m&&j<=r){
            if(a[i]<=a[j])
                t[k++]=a[i++];
            else{
                count+=m-i+1;
                t[k++]=a[j++];
            }
        }

        while(i<=m)t[k++]=a[i++];
        while(j<=r)t[k++]=a[j++];

        for(i=l;i<=r;i++)
            a[i]=t[i-l];

        return count;
    }

    static long sort(int[] a,int l,int r){
        if(l>=r)return 0;
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