class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        return dfs(0, mutableListOf(0), graph, BooleanArray(graph.size){false})
    }
    
    fun dfs(node: Int, history: MutableList<Int>,  graph: Array<IntArray>, vs: BooleanArray): List<List<Int>>{
        if(node == graph.size-1)
            return List(1){history.toList()}
        val result = mutableListOf<List<Int>>()
        vs[node] = true
        for(next in graph[node]){
            if(!vs[next]){
                history.add(next)
                result.addAll(dfs(next, history, graph, vs))
                history.removeAt(history.size-1)
            }
        }
        vs[node] = false
        return result.toList()
    }
}