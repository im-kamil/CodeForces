/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static long M = 1000000007;
    
    //FOR PAIR PROGRAMMING, DM ME IN LINKEDIN: https://www.linkedin.com/in/pravin-mudaliyar-022498224/
    
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader s = new FastReader();
        int T = s.nextInt();

        while (T-- > 0) {
            int N = s.nextInt();

            if (N == 1) {
                System.out.println("YES");
                System.out.println(s.nextInt());
                continue;
            }

            Map<Integer, Integer> freqHash = new HashMap<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            String ans = "YES";
            
            int max = 0;

            for (int i = 0; i < N; i++) {
                int val = s.nextInt();

                if (ans.equals("YES")) {
                    
                    freqHash.put(val, freqHash.getOrDefault(val, 0) + 1);

                    int freq = freqHash.get(val);

                    if (freq == 3) {
                        ans = "NO";
                    } else if (freq == 1) {
                        list1.add(val);
                    } else if(freq == 2) {
                        list2.add(val);
                    }
                    
                    max = Math.max(max, val);

                }
            }
    
            if (ans.equals("YES")) {
                
                if(freqHash.get(max) > 1){
                    System.out.println("NO");
                    continue;
                }
                
                Collections.sort(list1);
                Collections.sort(list2);
                
                if(list2.size() != 0 && list1.get(list1.size() - 1) == list2.get(list2.size() - 1)){
                    System.out.println("NO");
                    continue;
                }
                
                System.out.println("YES");
                
                StringBuilder perm = new StringBuilder();

                for (int i = 0; i < list1.size(); i++) {
                    perm.append(list1.get(i) + " ");
                }

                for (int i = list2.size() - 1; i >= 0; i--) {
                    perm.append(list2.get(i) + " ");
                }

                perm.deleteCharAt(perm.length() - 1);
                
                System.out.println(perm);
                continue;
            }

            System.out.println("NO");

        }
	}
	
	private static int[] takeArrInput(FastReader fr, int N) {
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }

        return arr;
    }
	
}

/*
10
5
1 1 2 2 3
4
3 3 3 3
6 
1 2 3 1 2 3
7
1 2 2 3 4 4 1
6
1 2 3 2 3 2
2
2 2
5
11 12 12 14 14 15
10
15 12 25 13 12 15 20 11 20 13
9
5 25 2 10 25 2 30 35 10
10
15 12 25 13 12 15 25 11 20 13

[1 2 3 2 1, NO, NO, NO, NO, NO, NO, 11 12 13 15 20 25 20 15 13 12, 2 5 10 25 30 35 25 10 2, NO]
*/


class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
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




