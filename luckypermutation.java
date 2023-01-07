import java.io.*;
import java.util.*;
public class luckypermutation{
     
     static long mod=998244353;
     static int ans=0;
     static int[] par=new int[200005];
     static int[] rank=new int[200005];
 
     static BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
     static PrintWriter pw=new PrintWriter(System.out);
     public static void main(String[] args)throws Exception{
          int T=Integer.parseInt(br.readLine());
          // int t=1;
          // comp();
          // int T=1;
          StringBuilder sb=new StringBuilder();
          while(T-->0)
          {
             solve(sb);                
          }
          pw.println(sb);
          pw.flush();
     }
  public static void solve(StringBuilder sb)throws Exception
  {
        String[] str=br.readLine().split(" ");
        // Reader rd=new Reader();
        // int n=rd.nextInt();
        int n=Integer.parseInt(str[0]);
        // int m=Integer.parseInt(str[1]);
        // int d=Integer.parseInt(str[2]);
        
        str=br.readLine().split(" ");
        // int[] arr=new int[n+1];
        HashSet<Integer> set=new HashSet<>();
        initialize(n+1);
        for(int i=1;i<=n;i++)
        { 
          int x=Integer.parseInt(str[i-1]);
          // arr[i]=x;
          union(x,i);
        }
        for(int i=1;i<=n;i++)
        {
          int led=find(i);
          set.add(led);
        }
        int cycles=set.size();

        int min=Integer.MAX_VALUE;

        for(int i=1;i<n;i++)
        {
          int li=find(i);
          int lip1=find(i+1);
          if(li==lip1)
          {
             min=Math.min(n-(cycles+1),min);
          }else
          {
            min=Math.min(n-(cycles-1),min);
          }
        }
        pw.println(min);
  }
  public static boolean pf(int[] arr,int k)
  {
      int n=arr.length;
      int[] darr=new int[n];
      for(int i=0;i<n;i++)
      {
        darr[i]=arr[i];
      }
      for(int i=n-1;i>=2;i--)
      {  
         if(darr[i]<k)return false;
         int extra=darr[i]-k;
         darr[i]=k;
         extra=Math.min(extra,arr[i]);
         int d=extra/3;
         darr[i-1]+=d;
         darr[i-2]+=2*d;
      }
      for(int i=0;i<n;i++)
      {
        if(darr[i]<k)return false;
      }
      return true;
  }
  public static void dfs(int u,ArrayList<Integer>[] adj,boolean[] visited,HashSet<Integer>[] ans)
  {    
       if(visited[u])return;
 
       visited[u]=true;
       for(int v:adj[u])
       {  
          dfs(v,adj,visited,ans);
          for(int x:ans[v])
          {
            ans[u].add(x);
          }
       }
       ans[u].add(u);
  }
  //*************************inclusion exclusion principal************************* */
  public static long getCombinationsOfbi(long x,long y,long m)
  {
       ArrayList<Long> factors=primeFactors(x/y);
      
       long size=factors.size();
       long total_combination=m/y;
 
       long ans=total_combination;
       for(long i=1;i<(1l<<size);i++)
       {  
          long unfac=1;
          for(int j=0;j<size;j++)
          {
            if(((i>>j)&1)==1)
            {
               unfac*=factors.get(j);
            }
          }
          
          if((Long.bitCount(i)&1)==1)
          {
              ans-=total_combination/unfac;
          }else
          {
              ans+=total_combination/unfac;
          }
          
       }
      
       return ans;
  }
  /***********************this class helps to use pair as key in hashmap***************/  
  public static class PPair
  {
    int u,v,hashCode;
    PPair(int u,int v)
    {
      this.u=u;
      this.v=v;
      this.hashCode = Objects.hash(u, v);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PPair that = (PPair) o;
        return u == that.u && v == that.v;
    }
 
    @Override
    public int hashCode() {
        return this.hashCode;
    }
 
  }
  /*********************************************nge********************************************* */
  //  public static int[] nextGreaterElement(int[] arr,int n)
  //  {    // 1 indexing
  //      int[] nge=new int[n+1];
  //      Stack<Pair> st=new Stack<>();
  //      for(int i=n;i>0;i--)
  //      {
  //          while(st.size()>0&&st.peek().val<=arr[i])st.pop();
  //          if(st.size()==0)
  //          {
  //             nge[i]=n+1;
  //          }else
  //          {
  //             nge[i]=st.peek().idx;
  //          }
  //          st.push(new Pair(arr[i],i));
  //      }
  //      return nge;
  //  }
 
   public static long NCR(int n,int r){ 
     if(r==0||r==n)return 1;
     return (fac[n]*invfact[r]%mod)*invfact[n-r]%mod;
   }
   static long[] fac=new long[10002];
   static long[] invfact=new long[10002];
   public static void comp(){
        fac[0]=1;
        invfact[0]=1;
        for(int i=1;i<10002;i++){
          fac[i]=(fac[i-1]*i)%mod;
          invfact[i]=modInverse(fac[i]);
        }
   }
 
   public static long modInverse(long n){
    return power(n,mod-2);
   }
 
   public static long power(long x,long y){
    long res=1;
    x=x%mod;
    while(y>0){
      if((y&1)==1)res=(res*x)%mod;
      y=y>>1;
      x=(x*x)%mod;
    }
    return res;
   }
 //*************************************DSU************************************ */
   public static void initialize(int n){
        for(int i=1;i<=n;i++){
            par[i]=i;
            rank[i]=1;
        }
        
    }
    public static void union(int x,int y){
        int lx=find(x);
        int ly=find(y);
 
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
              par[ly]=lx;
            }else if(rank[lx]<rank[ly]){
              par[lx]=ly;
            }else{
                par[lx]=ly;
                rank[ly]++;
            }
        }
    }
 
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
//************************************DSU END********************************** */
 
 public static boolean isPresent(ArrayList<Long> zero,long val){
     for(long x:zero){
         if(x==val)return true;
     }
     return false;
 }
 public static class Pair implements Comparable<Pair>{
     int x;
     int y;
     Pair(int x,int y){
          this.x=x;
          this.y=y;
     }
     public int compareTo(Pair o){
          return this.y-o.y;
     }
 }
 
  public static int countDigit(int x){
    return (int)Math.log10(x)+1;
  }
//******************************giver prime factor upto approx. 1e9***************************************
public static ArrayList<Long> primeFactors(long n)
{
        ArrayList<Long> primeFac=new ArrayList<>();
        long[] d={2,3,5};
        for(long f:d)
        {
          if(n%f==0)primeFac.add(f);
          while(n%f==0)n/=f;
        }
        long[] increments={4,2,4,2,4,6,2,6};
        int i=0;
        for(long f=7;f*f<=n;f+=increments[i++])
        {
          if(n%f==0)primeFac.add(f);
          while(n%f==0)n/=f;
          if(i==8)i=0;
        }
        if(n>1)primeFac.add(n);
        return primeFac;
}    
//****************************function to find all factor*************************************************          
     public static ArrayList<Long> findAllFactors(long num){
          ArrayList<Long> factors = new ArrayList<Long>();
         
        for(long i = 1; i <= num/i; ++i) {
            if(num % i == 0) {
                //if i is a factor, num/i is also a factor
                factors.add(i);
                factors.add(num/i);
            }
        }
         
        //sort the factors
        Collections.sort(factors); 
        return factors;
     }
//*************************** function to find GCD of two number*******************************************     
     public static long gcd(long a,long b){
          if(b==0)return a;
          return gcd(b,a%b);
     }
 
     static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
    }
}