// Author : Shadman Shariar //
import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
public class Solution {
//public static Main obj = new Main();
public static final long N = (long)(1000000001);
public static final long bigmod = 1_000_000_007;
public static final String vowels = "aeiouAEIOU";
public static final Random random = new Random();
public static int [] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
public static int [] dy = {0, 0, -1, 1, -1, 1, -1, 1};
public static final long mod = (long)(Math.pow(10,9)+7);
//public static FastReader fr = new FastReader();
//public static Scanner input = new Scanner(System.in);
//public static PrintWriter pw = new PrintWriter(System.out);
//public static DecimalFormat df = new DecimalFormat(".000");
//public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static void main (String[]args) throws Exception{Scanner input=new Scanner(System.in);
//===========================================================================================//
//Vector vc = new Vector();
//BigInteger bi = new BigInteger("1000");
//StringBuilder sb = new StringBuilder();
//StringBuffer sbf = new StringBuffer();
//StringTokenizer st = new StringTokenizer("string","split");
//ArrayList<Integer> al= new ArrayList<Integer>();
//LinkedList<Integer> ll= new LinkedList<Integer>();
//Stack <Integer> stk = new Stack <Integer>();
//Queue <Integer> q = new LinkedList<Integer>();
//ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
//PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
//PriorityQueue <Integer> pqr = new PriorityQueue<Integer>(Comparator.reverseOrder());
//HashSet<Integer> hs = new HashSet<Integer>();
//LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
//TreeSet<Integer> ts = new TreeSet<Integer>();
//TreeSet<Integer> tsr = new TreeSet<Integer>(Comparator.reverseOrder());
//Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
//HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
//LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<Integer,Integer>();
//TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
//TreeMap<Integer,Integer> tmr = new TreeMap<Integer,Integer>(Comparator.reverseOrder());
//ArrayList<ArrayList<Integer>> al2= new ArrayList<ArrayList<Integer>>();
//LinkedList<LinkedList<Integer>> ll2= new LinkedList<LinkedList<Integer>>();
//LinkedList<Integer> adj[] = new LinkedList[1000];
//ArrayList<Integer> adj2[] = new ArrayList[1000];
//===========================================================================================//
//long start = System.currentTimeMillis();

int tc = 1; 

tc = input.nextInt();

for (int tt = 1; tt <= tc; tt++) {


	
	
	int [] y = new int [3];
	int [] m = new int [3];
	int [] c = new int [3];
	int [] k = new int [3];
	
	int miny = 1000001;
	int minm = 1000001;
	int minc = 1000001;
	int mink = 1000001;
	
	for (int i = 0; i < 3; i++) {
		
		y[i] = input.nextInt();
		m[i] = input.nextInt();
		c[i] = input.nextInt();
		k[i] = input.nextInt();
		miny = Math.min(miny, y[i]);
		minm = Math.min(minm, m[i]);
		minc = Math.min(minc, c[i]);
		mink = Math.min(mink, k[i]);
		
	}

	if((miny+minm+minc+mink)<1000000) {
		System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
	}
	else if ((miny+minm+minc+mink)==1000000) {
		
		System.out.println("Case #"+tt+": "+miny+" "+minm+" "+minc+" "+mink);
		
	}
	else {
		
		int [] a = new int [4];
		
		a[0] = miny;
		a[1] = minm;
		a[2] = minc;
		a[3] = mink;
		
		int iy = -1, im = -1 , ic = -1, ik = -1;
		
		ruffleSort(a);
		
		for (int i = 0; i < 4; i++) {
			
			if(a[i]==miny && iy==-1){
				iy = i;
			}
			else if(a[i]==minm && im==-1){
				im = i;
			}
			else if(a[i]==minc && ic==-1){
				ic = i;
			}
			else if(a[i]==mink && ik==-1){
				ik = i;
			}
			
			
		}
		
		int [] sum = new int [4];
		
		sum[0] = a[0];
		sum[1] = sum[0]+a[1];
		sum[2] = sum[1]+a[2];
		sum[3] = sum[2]+a[3];
		int kn = 3;
		while (sum[kn]>1000000) {
			
			if(sum[kn]-1000000>a[kn]) {
				a[kn] = 0;
				kn--;
			}
			else {
				
				
			a[kn] = a[kn]-(sum[kn]-1000000);
				kn--;
			}
			
			
		}
		
		System.out.println("Case #"+tt+": "+a[iy]+" "+a[im]+" "+a[ic]+" "+a[ik]);
	}
	
}

//long end = System.currentTimeMillis();
//System.out.println("Time : "+((end-start)/1000));
//===========================================================================================//
//      pw.flush();
//      pw.close();
        input.close();
        System.exit(0);
}
//===========================================================================================//
//----->> Temporary Method Starts Here <<-----//
//----->>  Temporary Method Ends Here  <<-----//
//===========================================================================================//
public static long lcm(long a,long b){return (a/gcd(a,b))*b;}
public static long gcd(long a,long b){if(a==0)return b;return gcd(b%a,a);}
public static long nPr(long n,long r){return factorial(n)/factorial(n-r);}
public static long nCr(long n,long r){return factorial(n)/(factorial(r)*factorial(n-r));}
public static long factorial(long n){return (n==1||n==0)?1:n*factorial(n-1);}
public static long countsubstr(String str){long n=str.length();return n*(n+1)/2;}
public static long fastpower(long a,long b,long n) {long res=1;while(b>0){if((b&1)!=0)
{res=(res*a%n)%n;}a=(a%n*a%n)%n;b=b>>1;}return res;}
public static void subsequences(String s,String ans){if(s.length()==0){ss.
add(ans);return;}subsequences(s.substring(1),ans+s.charAt(0));subsequences
(s.substring(1),ans);}public static List<String>ss=new ArrayList<>();
public static boolean perfectsquare(long x){if(x>=0)
{long sr=(long)(Math.sqrt(x));return((sr*sr)==x);}return false;}
public static boolean perfectcube(long N){int cube;int c=0;for(int i=0;i<=N;i++){cube=i*i*i;
if(cube==N){c=1;break;}else if (cube>N){c=0;break;}}if(c==1)return true;else return false;}
public static boolean[] sieveOfEratosthenes(int n){boolean prime[]=new boolean[n+1];
for (int i = 0; i <= n; i++)prime[i] = true;for (int p = 2; p * p <= n; p++){
if(prime[p]==true){for(int i=p*p;i<=n;i+=p)prime[i]=false;}}prime[1]=false;return prime;}
public static int binarysearch(int arr[],int l,int r,int x) 
{if (r >= l){int mid = l + (r - l) / 2;if (arr[mid]==x)return mid;if(arr[mid]>x)return
binarysearch(arr, l, mid - 1, x);return binarysearch(arr, mid + 1, r, x);}return -1;}
public static void rangeofprime(int a,int b){int i, j, flag;for (i = a; i <= b; i++)
{if (i == 1 || i == 0)continue;flag = 1;for (j = 2; j <= i / 2; ++j) {if (i % j == 0)
{flag = 0;break;}}if (flag == 1)System.out.println(i);}}
public static boolean isprime(long n){if(n<=1)return false;else if(n==2)return true;else if
(n%2==0)return false;for(long i=3;i<=Math.sqrt(n);i+=2){if(n%i==0)return false;}return true;}
//===========================================================================================//
public static void debug(Object... obj) {
    System.err.println(Arrays.deepToString(obj));
}
static void ruffleSort(int[] a) {
	int n=a.length;
	for (int i=0; i<n; i++) {
		int oi=random.nextInt(n), temp=a[oi];
		a[oi]=a[i]; a[i]=temp;
	}
	Arrays.sort(a);
}
public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long[] readArrayL(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}