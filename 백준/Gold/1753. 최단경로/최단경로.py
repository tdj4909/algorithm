import heapq, sys
input = sys.stdin.readline

def dijkstra(start):
    hq = []
    heapq.heappush(hq,start)
    distance[start[1]] = start[0]
    while hq:
        curr_dist, curr_node = heapq.heappop(hq)
        for next_dist, next_node in graph[curr_node]:
            if distance[next_node] > distance[curr_node] + next_dist:
                distance[next_node] = distance[curr_node] + next_dist
                heapq.heappush(hq,(distance[next_node],next_node))


V, E = map(int,input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
distance = [float("INF")] * (V+1)

for _ in range(E):
    u, v, w = map(int,input().split())
    graph[u].append((w,v))

dijkstra((0,K))

for i in distance[1:]:
    if i == float("inf"):
        print("INF")
    else:
        print(i)