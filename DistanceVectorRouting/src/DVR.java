import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class DVR {
    static int ii;
    DVR(int i)
    {
        ii=i;
    }
    static int graph[][];
    static int N,E;
    static RT node[];
    public static void initG()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i==j)
                {
                    continue;
                }
                else
                {
                    graph[i][j]=99;//assuming 99 is infinite
                }
            }
        }
    }

    public static void constructGraph()
    {
        System.out.println("enter nodes and edges");
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        E=sc.nextInt();
        graph = new int[N][N];
        initG();
        int s,d,c;

        for(int i=0;i<E;i++)
        {
            System.out.println("src dest cost");
            s=sc.nextInt();
            d=sc.nextInt();
            c=sc.nextInt();
            graph[s][d]=c;
            graph[d][s]=c;
        }
    }

    public static void uploadGraph() throws Exception
    {
        int s,d,c;//src dest cost
        Scanner sc=new Scanner(new FileReader("C:\\Users\\NIT-STUDENT\\Desktop\\411623\\DistanceVectorRouting\\Graph.txt"));
        N=sc.nextInt();
        E=sc.nextInt();
        graph=new int[N][N];
        initG();
        for(int j=0;j<E;j++)
        {
            s=sc.nextInt();
            d=sc.nextInt();
            c=sc.nextInt();
            graph[s][d]=c;
            graph[d][s]=c;
        }

    }

    public static void printGraph()
    {
        System.out.println("printing Graph");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int p=0;
    public static void printTab(String msg)
    {
            System.out.println(msg);
            for (int i = 0; i < N; i++) {
                System.out.println("\nRT at " + i + "\n");
                for (int j = 0; j < N; j++) {
                    System.out.println(j + "  " + node[i].dist[j] + "  " + node[i].via[j]);
                }
            }
    }

    public static void xchg(int i)
    {
        //from node i
        System.out.println("to node"+i);
        for(int j=0;j<N;j++)//sending its routing vector to j
        {
            if(i==j) continue;
            if(node[i].dist[j]!=99)
            {
                //node[i].update(node[j].dist,j);
                int p[]=new int[N];
                for(int k=0;k<N;k++)//for calulating new distance
                {
                    p[k]=node[j].dist[k]+node[j].dist[i];
                }
                node[i].push(p,j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //constructGraph();
        uploadGraph();
        printGraph();
        node = new RT[N];
        for (int i = 0; i < N; i++) {
            node[i] = new RT(i, N, graph);
        }
        printTab("printing initial tables");


        //passing routing vectors
        for (int j = 0; j < N; j++)
        {
            for (int i = 0; i < N; i++)
            {
                xchg(i);
                node[i].update();
            }
            for(int i=0;i<N;i++)
            {
                node[i].newdist_to_dist();
            }
            printTab("printing tables after convergence "+(j+1));
        }

    }
}
