class Solution {
    private static final char[] BASES = { 'A', 'C', 'G', 'T' };

    public int minMutation(String start, String end, String[] bank) {
        // always a good idea to validate input for null/empty string during interviews
        // (even if the problem constraints say otherwise)
        if (start == null || end == null || start.length() == 0 || end.length() == 0)
            return -1;
        if (start.compareTo(end) == 0)
            return 0;

        // Set for storing all genes in the bank + start gene
        Set<String> geneBank = new HashSet<>();

        // Set for keeping track of visited genes during BFS
        Set<String> visited = new HashSet<>();

        for (String gene : bank)
            geneBank.add(gene);
        geneBank.add(start);

        // Adjacency List for storing all genes and their corresponing mutated /
        // neighbor genes who differ by 1 character (DNA base/protein)
        HashMap<String, List<String>> adj = new HashMap<>();

        buildAdjacencyList(geneBank, adj);
        return bfs(start, end, adj, visited);
    }

    private int bfs(String start, String end, HashMap<String, List<String>> adj, Set<String> visited) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int mutations = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String currGene = q.poll();
                for (String neighborGene : adj.get(currGene)) {
                    if (neighborGene.compareTo(end) == 0)
                        return mutations;
                    if (!visited.contains(neighborGene)) {
                        visited.add(neighborGene);
                        q.offer(neighborGene);
                    }
                }
            }
            ++mutations;
        }

        return -1;
    }

    private void buildAdjacencyList(Set<String> geneBank, HashMap<String, List<String>> adj) {
        Iterator<String> it = geneBank.iterator();

        while (it.hasNext()) {
            String gene = it.next();
            adj.put(gene, new ArrayList<String>());

            char[] geneChar = gene.toCharArray();
            for (int i = 0; i < 8; i++) {
                char currBase = geneChar[i];
                for (char base : BASES) {
                    // For each character (base) in the gene, we mutate it to each of the available
                    // bases (A, G, T, C)
                    geneChar[i] = base;
                    String mutatedGene = new String(geneChar);
                    // If the mutated gene exists in the word bank, then this means that there
                    // exists an edge between the current gene and the mutated gene in the graph
                    if (geneBank.contains(mutatedGene)) {
                        adj.get(gene).add(mutatedGene);
                    }
                }
                geneChar[i] = currBase;
            }
        }
    }
}