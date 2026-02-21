package newLearning.Graph.Algos;

import java.util.Arrays;

public class Disjoint {

    class DSU{
        int[] rank;
        int[] parent;
        int[] size;
        DSU(int n){
            rank = new int[n+1];
            parent = new int[n+1];
            size = new int[n+1];
            Arrays.fill(rank, 0);
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        /*
            This method does the path compression and also gives us the ultimate parent of node u
         */
        public int find(int u){
            if(u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }

        public void unionByRank(int u, int v){
            int ulp_u = find(u);
            int ulp_v = find(v);
            if(ulp_u == ulp_v) return;
            /*
                Let say we have two component
                    a-b-c
                    and
                    e-f-g-h

                    if we attach a-b-c to e-f-g-h the height for the  e-f-g-h will remain same

                    union(c,h)
                    pu = find ultimate parent of c = which is a
                    pv = find ultimate parent of h = which is e
                now check for the rank of both

                3 cases:
                   1)   if rank of pv is greater pu gets connected to pv
                            why don't we increase rank here because a smaller component is getting connected to greater one
                        or
                   2)   if rank of pu is greater pv gets connected to pu
                            why don't we increase rank here because a smaller component is getting connected to greater one
                        or
                   3)  if rank of both pu and pv are same it doesn't matter which gets connected to whom the rank always increases
                    a gets connected to e right
                    so  pu will hold the value of pv means
                    parent[pu] = pv;
             */
            if(rank[ulp_v] > rank[ulp_u]){
                parent[ulp_u] =  ulp_v;
            }else if(rank[ulp_v] < rank[ulp_u]){
                parent[ulp_v] = ulp_u;
            }else{
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }


        /*
            In this union what we do is like instead of comparing by the ranks
            we compare it by the size of the component

            2 cases:

             1) if ulp_u is of size 4 and ulp_v is of size 3 means in component u we have 4 nodes
                and in component v we have 3 nodes so we always make sure to attach the smaller tree
                with the greater tree right so in this case ulp_v will get attach to ulp_u because it has
                nodes more than the ulp_v and also the size of the ulp_u will increase by size[ulp_v] why
                because these nodes we're attaching in out ulp_u

            2) if ulp_u and ulp_v are same than no matter what you attach in what it'll work fine

         */
        public void unionBySize(int u, int v){
            int ulp_u = find(u);
            int ulp_v = find(v);
            if(size[ulp_u] > size[ulp_v]){
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }else{
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }
        }

    }

    public static void main(String[] args) {
        Disjoint d = new Disjoint();
        Disjoint.DSU dsu = new Disjoint().new DSU(7);
        dsu.unionBySize(1,2);
        dsu.unionBySize(2,3 );
        dsu.unionBySize(4,5);
        dsu.unionBySize(6,7);
        dsu.unionBySize(5,6);

        if(dsu.find(1) == dsu.find(7))
            System.out.println("Same");
        else System.out.println("Different");

        dsu.unionBySize(3,7);

        if(dsu.find(1) == dsu.find(7))
            System.out.println("Same");
        else System.out.println("Different");
    }

}
