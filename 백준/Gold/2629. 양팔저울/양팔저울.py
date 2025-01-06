import sys
input = sys.stdin.readline

def dfs():
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            tmp = set()
            for j in dp:
                tmp.add(j+weight[i])
                tmp.add(abs(j-weight[i]))
            for j in tmp:
                dp.add(j)
            dfs()


N = int(input())
weight = list(map(int,input().split()))
visited = [0]*N
M = int(input())
marbles = list(map(int,input().split()))
dp = set()
dp.add(0)

dfs()

for i in marbles:
    if i in dp:
        print("Y",end=" ")
    else:
        print("N",end=" ")