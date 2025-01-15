import sys
input = sys.stdin.readline

N, M = map(int,input().split())
height = list(map(int,input().split()))
height.sort()

start = 0
end = height[-1]
result = 0
while start <= end:
    mid = (start+end)//2
    height_sum = 0
    for i in height:
        if i - mid > 0:
            height_sum += i-mid
    if height_sum >= M:
        result = max(result,mid)
        start = mid + 1
    else:
        end = mid - 1

print(result)