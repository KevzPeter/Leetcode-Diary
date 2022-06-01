/**
 * Disjoint-Set using union by rank and path compression
 */
public class DisjointSet{
    private int[] root;
    private int[] rank;
    public DisjointSet(int size){
        this.root = new int[size];
        this.rank = new int[size];
        for(int i = 0; i < size; i++){
            this.root[i] = i;
            this.rank[i] = i;
        }
    }
    public int findRoot(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = findRoot(root[x]);
    }
    public void union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX != rootY){
            if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY; 
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}