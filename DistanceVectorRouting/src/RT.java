public class RT {
    public int dist[],via[];
    int N;
    int node;
    public void init()
    {
        dist=new int[N];
        via=new int[N];
        for(int i=0;i<N;i++)
        {
            if(node==i)
            {
                via[i]=node;
            }
            else {
                via[i] = 99;
            }
        }
    }

    RT(int node,int N,int[][] G)
    {
        this.node=node;
        this.N=N;
        init();
        dist=G[node];
        for(int i=0;i<N;i++)
        {
            if(dist[i]!=99)
            {
                via[i]=i;
            }
        }
    }

    public void update(int rv[],int rvnode)
    {
        int distij=dist[rvnode];
        for(int i=0;i<N;i++)
        {
            if(dist[i]>rv[i]+distij)
            {
                dist[i]=rv[i]+distij;
                via[i]=rvnode;
            }
        }
    }
}
