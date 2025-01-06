import heapq, sys
input = sys.stdin.readline

def dijkstra(start):
    pq = []
    distance[start] = 0
    heapq.heappush(pq, (0,start))
    while pq:
        curr_dist, curr_node = heapq.heappop(pq)
        if curr_dist > distance[curr_node]:
            continue
        for next_dist, next_node in graph[curr_node]:
            cost = curr_dist + next_dist
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(pq,(cost,next_node))


T = int(input())
for _ in range(T):
    n, m, t = map(int,input().split())
    s, g, h = map(int,input().split())
    graph = [[] for i in range(n+1)]
    distance = [int(1e9)] * (n+1)
    target = []
    g_dist = 0
    h_dist = 0
    result_dist = 0
    result_loc = []

    for i in range(m):
        a, b, d = map(int,input().split())
        graph[a].append((d,b))
        graph[b].append((d,a))

    for i in range(t):
        target.append(int(input()))

    dijkstra(s)
    target_dist = []
    for i in target:
        target_dist.append(distance[i])
    g_dist = distance[g]
    h_dist = distance[h]

    distance = [int(1e9)] * (n + 1)
    dijkstra(g)
    result_dist = h_dist + distance[h]
    for i in range(t):
        if target_dist[i] == result_dist + distance[target[i]]:
            result_loc.append(target[i])

    distance = [int(1e9)] * (n + 1)
    dijkstra(h)
    result_dist = g_dist + distance[g]
    for i in range(t):
        if target_dist[i] == result_dist + distance[target[i]]:
            result_loc.append(target[i])

    result_loc = list(set(result_loc))
    result_loc.sort()
    print(*result_loc)