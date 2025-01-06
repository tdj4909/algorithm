X, Y = input().split()
X, Y = int(X[::-1]), int(Y[::-1])
print(int(str(X+Y)[::-1]))