import sys
input = sys.stdin.readline

K, N = map(int,input().split())
L = []
for _ in range(K):
    L.append(int(input()))

L.sort()
start = 0
end = max(L)
answer = 0

while start <= end:
    mid = (start + end) // 2
    if not mid:
        answer = 1
        break
    result = 0
    for i in L:
        result += i//mid

    if result >= N:
        answer = max(answer,mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)