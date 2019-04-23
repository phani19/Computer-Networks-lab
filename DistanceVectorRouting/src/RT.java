public class RT {
    public int dist[],via[],newdist[],newvia[],updatetab[][];
    int N;
    int node;
    public void init()
    {
        newvia=new int[N];
        newdist=new int[N];
        dist=new int[N];
        via=new int[N];
        for(int i=0;i<N;i++)
        {
            if(node==i)
            {
                via[i]=node;
                newvia[i]=node;
            }
            else {
                via[i] = 99;
                newvia[i]=99;
            }
        }

        updatetab=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                updatetab[i][j]=99;
            }
        }
    }

    RT(int node,int N,int[][] G)
    {
        this.node=node;
        this.N=N;
        init();
        dist=G[node];
        newdist=G[node];
        for(int i=0;i<N;i++)
        {
            if(dist[i]!=99)
            {
                via[i]=i;
                newvia[i]=i;
            }
        }
        newdist=dist.clone();
    }


    public void push(int p[],int fromnode)
    {
        System.out.println("from node "+fromnode);
        for(int j=0;j<N;j++)
        {
            updatetab[j][fromnode]=p[j];
        }
    }

    public void update()
    {
        for(int j=0;j<N;j++)
        {
            updatetab[j][node]=dist[j];
        }
        //all exchange values had been updated
        for(int i=0;i<N;i++)//for each node
        {
            newdist[i]=99;
            for(int j=0;j<N;j++)
            {
                if(updatetab[i][j]<newdist[i])
                {
                    newdist[i]=updatetab[i][j];
                    if(newdist[i]!=99)
                    newvia[i]=j;
                }
            }
        }
    }

    public void newdist_to_dist()
    {
        for(int i=0;i<N;i++)
        {
            dist[i]=newdist[i];
            via[i]=newvia[i];
        }
    }
}

