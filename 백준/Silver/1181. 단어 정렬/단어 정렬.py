import sys
N = int(input())
words = []
for _ in range(N):
    word = sys.stdin.readline().rstrip()
    words.append((len(word), word)) 

words = sorted(set(words), key=lambda x : (x[0], x[1]))
for i in words:
    print(i[1])