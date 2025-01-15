K = int(input())
for i in range(1,K+1):
    scores = list(map(int,input().split()))[1:]
    scores.sort(reverse=True)
    result = 0
    for j in range(1,len(scores)):
        result = max(result,scores[j-1]-scores[j])
    print("Class", i)
    print(f"Max {scores[0]}, Min {scores[-1]}, Largest gap {result}")