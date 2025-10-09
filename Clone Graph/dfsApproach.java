/*
// Definition for a Node.
class dfsApproach {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node ==null) return null;
        map = new HashMap<>();
        Node root= dfs(node);
        return root; 
    }
    private Node dfs(Node node){
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val,new ArrayList<>());
        map.put(node,clone);

        for(Node nbg : node.neighbors){
            clone.neighbors.add(dfs(nbg));
        }
        return clone;
    }

}