T = int(input())
for _ in range(T):
    x1,y1,r1,x2,y2,r2 = map(int,input().split())
    d = ((x2-x1)**2+(y2-y1)**2)**0.5

    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
    elif x1 == x2 and y1 == y2 and r1 != r2:
        print(0)
    elif r1 > d+r2 or r2 > d+r1:
        print(0)
    elif r1 == d+r2 or r2 == d+r1:
        print(1)
    elif d == r1+r2:
        print(1)
    elif d > r1+r2:
        print(0)
    elif d < r1+r2:
        print(2)