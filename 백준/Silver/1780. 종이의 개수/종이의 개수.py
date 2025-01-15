import sys
input = sys.stdin.readline

def division(n,x,y):
    global minus_Sum, zero_Sum, plus_Sum
    divide = False
    standard = board[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if board[i][j] != standard:
                divide = True
                break
        if divide:
            break
    if not divide:
        if standard == -1:
            minus_Sum += 1
            return
        elif standard == 0:
            zero_Sum += 1
            return
        else:
            plus_Sum += 1
            return
    else:
        division(n // 3, x, y)
        division(n // 3, x, y + n // 3)
        division(n // 3, x, y + n*2 // 3)

        division(n // 3, x + n // 3, y)
        division(n // 3, x+ n // 3, y + n // 3)
        division(n // 3, x+ n // 3, y + n * 2 // 3)

        division(n // 3, x + n*2 // 3, y)
        division(n // 3, x + n*2 // 3, y + n // 3)
        division(n // 3, x + n*2 // 3, y + n * 2 // 3)


N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]
minus_Sum = 0
zero_Sum = 0
plus_Sum = 0

division(N,0,0)

print(minus_Sum)
print(zero_Sum)
print(plus_Sum)