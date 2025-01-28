# https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

class Graph:

    def __init__(self):
        self.graph = dict()

    def addEdge(self, u, v):
        # Check if u is already a key in the graph
        if u not in self.graph:
            self.graph[u] = []  # Initialize an empty list for the key
        self.graph[u].append(v)

    def BFS(self, v):
        # Create a queue for BFS
        q = []

        # Initially mark all the vertices as not visited
        # When we push a vertex into the q, we mark it as
        # visited
        visited = [False] * len(self.graph)

        # mark the source node as visited and enqueue it
        visited[v] = True
        q.append(v)

        # itereate over teh queue
        while q:
            # dequeue a vertex from queue and print it
            curr = q.pop(0)
            print(curr, end=" ")

            # get all adjacent vertices of the dequeued
            # vertex. if an adjacent has not been visited,
            # mark it visited and enqueue it
            for x in self.graph[curr]:
                if not visited[x]:
                    visited[x] = True
                    q.append(x)

# Driver's code
if __name__ == "__main__":
    g = Graph()
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

    print("Following is Breadth First Traversal (starting from vertex 0)")
    
    # Function call
    g.BFS(0)


