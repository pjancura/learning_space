# https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/


class Graph:

    def __init__(self):
        self.graph = dict()

    def addEdge(self, u, v):
        # Check if u is already a key in the graph
        if u not in self.graph:
            self.graph[u] = []  # Initialize an empty list for the key
        self.graph[u].append(v)

    def DFSUtil(self, v, visited):

        # Mark the current node as visited
        # and print it
        visited.add(v)
        print(v, end=" ")

        # Recur for all the vertices
        # adjacent to this vertex
        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.DFSUtil(neighbour, visited)
        
    def DFS(self, v):

        # Create a set to store visited vertices
        visited = set()

        # Call the recursive helper function
        # to print DFS traversal
        self.DFSUtil(v, visited)


# Driver's code
if __name__ == "__main__":
    g = Graph()
    # g.addEdge(0, 1)
    # g.addEdge(0, 2)
    # g.addEdge(1, 2)
    # g.addEdge(2, 0)
    # g.addEdge(2, 3)
    # g.addEdge(3, 3)

    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(1, 3)
    g.addEdge(1, 4)
    g.addEdge(4, 4)
    g.addEdge(2, 0)
    g.addEdge(2, 1)
    g.addEdge(3, 5)
    g.addEdge(5, 8)
    g.addEdge(5, 7)
    g.addEdge(5, 6)
    g.addEdge(6, 6)
    g.addEdge(7, 8)
    g.addEdge(8, 9)
    g.addEdge(9, 9)

    print("Following is Depth First Traversal (starting from vertex 0)")
    
    # Function call
    g.DFS(0)