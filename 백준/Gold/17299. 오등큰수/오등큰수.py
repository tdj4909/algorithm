import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int,input().split()))
F = {}
answer = [-1] * N
stack = [0]

for i in A:
    if i in F:
        F[i] += 1
    else:
        F[i] = 1

for i in range(1,N):
    while stack and F[A[stack[-1]]] < F[A[i]]:
        answer[stack.pop()] = A[i]
    stack.append(i)

print(*answer)