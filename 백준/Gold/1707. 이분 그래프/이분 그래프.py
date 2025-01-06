import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline

def dfs(n, check):
    global circulation
    for next in graph[n]:
        if not visited[next]:
            visited[next] = -check
            dfs(next, -check)
        elif visited[next] == check:
            circulation = True
            return


K = int(input())
for _ in range(K):
    V, E = map(int,input().split())
    graph = [[] for i in range(V+1)]
    visited = [0] * (V + 1)
    circulation = False

    if E == 1:
        print("YES")
        break

    for i in range(E):
        u, v = map(int,input().split())
        graph[u].append(v)
        graph[v].append(u)

    for i in range(1,V+1):
        if not visited[i]:
            dfs(i,1)

    if circulation:
        print("NO")
    else:
        print("YES")