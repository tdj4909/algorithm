import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(n):
    global cnt
    visited[n] = cnt
    cnt += 1
    for i in graph[n]:
        if not visited[i]:
            dfs(i)


N, M, R = map(int,input().split())
graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)
cnt = 1

for _ in range(M):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

for row in graph:
    row.sort()

dfs(R)

for i in range(1,N+1):
    print(visited[i])