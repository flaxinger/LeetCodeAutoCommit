class Solution {
    
    private val result = mutableListOf<Int>();
    
    // course & courses that can be taken after this
    private var graph = mutableMapOf<Int, NodeInfo>()
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        
        for(i in 0 until numCourses){
            graph[i] = NodeInfo()
        }
        for(arr in prerequisites){
            graph[arr[1]]?.unlocksCourses?.add(arr[0])
            graph[arr[0]]?.apply{
                remainingPrerequisites++
            }
        }
        graph = graph.toList()
            .sortedBy{ (key, value) -> value.remainingPrerequisites }
            .toMap()
            .toMutableMap()
        
        var idx = 0
        val nodeOrder = graph.keys.toList()
        while(idx < numCourses && result.size < numCourses){
            if(graph[nodeOrder[idx]]?.remainingPrerequisites==0){
                traverse(nodeOrder[idx])
            }
            idx++
        }
        if(result.size == numCourses) return result.toIntArray()
        return IntArray(0)
    }
    
    fun traverse(root: Int){
        result.add(root)
        graph[root]?.let{ nodes ->
            for(node in nodes.unlocksCourses){
                graph[node]?.apply{
                    remainingPrerequisites--
                }
                if(graph[node]?.remainingPrerequisites==0){
                    traverse(node)
                }
            }
        }
    }
    
    private class NodeInfo(
        var remainingPrerequisites: Int = 0,
        val unlocksCourses: MutableList<Int> = mutableListOf()
    ){
        override fun toString() = "[remaining: $remainingPrerequisites, unlocks $unlocksCourses]"
    }
    
}