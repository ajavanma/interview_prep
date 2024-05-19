# A graph is an abstract data type that represents a set of vertices and the edges that connect those vertices.

# 	0	    1	    2	    3	    4
# 0	false	true	false	false	true
# 1	true	false	true	true	true
# 2	false	true	false	true	false
# 3	false	true	true	false	true
# 4	true	true	false	true	false


[
  [False, True, False, False, True],
  [True, False, True, True, True],
  [False, True, False, True, False],
  [False, True, True, False, True],
  [True, True, False, True, False]
]


# ADJACENCY MATRIX
# An adjacency matrix is a square matrix used to represent a finite graph. 
# The elements of the matrix indicate whether pairs of vertices are adjacent or not in the graph. 
# true indicates the presence of an edge, false represents the absence.
class Graph:
    def __init__(self, num_vertices):
        # Fill the list with n lists, where n is the number of vertices in the graph
        # Each of these lists should contain n False values
        # Initialize the graph with num_vertices x num_vertices matrix filled with False
        # Each element in the inner lists represents whether there is an edge between the corresponding vertices
        #              inner loop                          # outer loop
        self.graph = [[False for _ in range(num_vertices)] for _ in range(num_vertices)]    # a list of lists


    # takes two vertices as inputs, and should add an edge to the graph by setting the corresponding cells to True
    def add_edge(self, u, v):
        # Add an edge by setting the corresponding cells to True
        self.graph[u][v] = True
        self.graph[v][u] = True  # Since it's an undirected graph

    def edge_exists(self, u, v):
        if u < 0 or u >= len(self.graph):
            return False
        if len(self.graph) == 0:
            return False
        row1 = self.graph[0]
        if v < 0 or v >= len(row1):
            return False
        return self.graph[u][v]

def main():
    g = Graph(5)  # Create a graph with 5 vertices
    g.add_edge(2, 3)  # Add edge between vertex 2 and vertex 3
    
    # Test if edge exists
    print(g.edge_exists(2, 3))  # prints True
    print(g.edge_exists(3, 2))  # prints True
    print(g.edge_exists(0, 1))  # prints False

main()




# An adjacency list stores a list of vertices for each vertex that indicates where the connections are.
# A dictionary of vertices that map to set of vertices

# 0	connects with	1	4		
# 1	connects with	0	2	3	4
# 2	connects with	1	3		
# 3	connects with	1	2	4	
# 4	connects with	0	1	3	

# approach:
# If vertex u is already a key in the dictionary, add v to u's set.
# Otherwise, create a new set for u that contains v.
# Repeat steps 1 & 2, but swap u and v.
class Graph:
    def __init__(self):
        # Initialize an empty dictionary for the adjacency list
        self.graph = {}

    # The dictionary maps vertices to a set of all other vertices they share an edge with.
    def add_edge(self, u, v):
        if u not in self.graph:
            self.graph[u] = set()   # If vertex u is not in the graph, add it with an empty set
        self.graph[u].add(v)        # Add vertex v to the adjacency set of u

        # do the same for v
        if v not in self.graph:
            self.graph[v] = set()
        self.graph[v].add(u)

    def edge_exists(self, u, v):
        if u in self.graph and v in self.graph:
            return (v in self.graph[u]) and (u in self.graph[v])
        return False

{
    "0": [1, 4],
    "1": [0, 2, 3, 4],
    "2": [1, 3],
    "3": [1, 2, 4],
    "4": [0, 1, 3]
}



def main():
    g = Graph()  # Create a graph
    g.add_edge(2, 3)  # Add edge between vertex 2 and vertex 3
    
    # Test if edge exists
    print(g.edge_exists(2, 3))  # True
    print(g.edge_exists(3, 2))  # True
    print(g.edge_exists(0, 1))  # False

main()










# usecase: location-based logic

class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v):
        if u in self.graph:
            self.graph[u].add(v)
        else:
            self.graph[u] = {v}
        
        if v in self.graph:
            self.graph[v].add(u)
        else:
            self.graph[v] = {u}

    # It takes a node (an integer) as input and returns a list of all the adjacent nodes in order
    def adjacent_nodes(self, node):
        # Return a sorted list of adjacent nodes
        if node in self.graph:
            return sorted(list(self.graph[node]))
        return []

    # don't touch below this line
    def edge_exists(self, u, v):
        if u in self.graph and v in self.graph:
            return (v in self.graph[u]) and (u in self.graph[v])
        return False

    #  It should return a list of vertices (integers) that have no connections.
    # A vertex with no edges will have an empty set as its value in the self.graph dictionary.
    def unconnected_vertices(self):
        return [node for node, neighbors in self.graph.items() if not neighbors]
    
    # alternative approach:
    def unconnected_vertices(self):
        # Return a list of vertices that have no connections (empty set) using .values()
        return [node for node in self.graph if not self.graph[node]]
        
    def add_node(self, u):
        if u not in self.graph:
            self.graph[u] = set()

def main():
    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 3)
    graph.add_edge(2, 3)
    
    adjacent_nodes = graph.adjacent_nodes(1)
    print(adjacent_nodes)  # Should print [0, 3]

main()