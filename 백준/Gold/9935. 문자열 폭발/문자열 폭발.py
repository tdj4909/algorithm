import sys
input = sys.stdin.readline

s = input().strip()
bomb_s = input().strip()
stack = []

for i in s:
    stack.append(i)
    if len(stack) >= len(bomb_s):
        while True:
            if ''.join(stack[-len(bomb_s):]) == bomb_s:
                for _ in range(len(bomb_s)):
                    stack.pop()
            else:
                break
if not len(stack):
    print("FRULA")
else:
    print(''.join(stack))