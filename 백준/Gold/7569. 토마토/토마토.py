from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        z, x, y = q.popleft()
        for i in range(6):
            nz, nx, ny = z + dz[i], x + dx[i], y + dy[i]
            if 0<=nx<N and 0<=ny<M and 0<=nz<H and (not tomato[nz][nx][ny] or tomato[nz][nx][ny] > tomato[z][x][y] + 1):
                tomato[nz][nx][ny] = tomato[z][x][y] + 1
                q.append((nz,nx,ny))


dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]

M, N, H = map(int,input().split())
tomato = [[list(map(int,input().split())) for _ in range(N)] for i in range(H)]
zero_check = False
tomato_check = False
answer = 0

for k in range(H):
    for i in range(N):
        for j in range(M):
            if tomato[k][i][j] == 0:
                zero_check = True

for k in range(H):
    for i in range(N):
        for j in range(M):
            if tomato[k][i][j] == 1:
                bfs((k,i,j))
                tomato_check =True

# 모두 익어 있는 상태
if not zero_check and tomato_check: # 0은 없고 1만 있는 상태
    print(0)
    exit()
# 모두 익지는 못하는 상태
elif not tomato_check: # 1이 없는 상태
    print(-1)
    exit()

for k in range(H):
    for i in range(N):
        for j in range(M):
            answer = max(answer,tomato[k][i][j])
            if tomato[k][i][j] == 0:
                print(-1)
                exit()


print(answer-1)