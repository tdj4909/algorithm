W = []
K = []

for _ in range(10):
    W.append(int(input()))
for _ in range(10):
    K.append(int(input()))

W.sort(reverse=True)
K.sort(reverse=True)

w = sum(W[0:3])
k = sum(K[0:3])

print(w,end=" ")
print(k)