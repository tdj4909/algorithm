import heapq, sys
input = sys.stdin.readline

N = int(input())
hq = []
for _ in range(N):
    x = int(input())
    if x > 0:
        heapq.heappush(hq,-x)
    else:
        if not len(hq):
            print(0)
        else:
            print(-heapq.heappop(hq))

