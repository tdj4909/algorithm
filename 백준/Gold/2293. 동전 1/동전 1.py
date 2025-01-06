import sys
input = sys.stdin.readline

n, k = map(int,input().split())
coins = [int(input()) for i in range(n)]
dp = [0]*(k+1)
dp[0] = 1

for i in coins:
    for j in range(k+1):
        if i+j <= k:
            dp[j+i] += dp[j]

print(dp[k])