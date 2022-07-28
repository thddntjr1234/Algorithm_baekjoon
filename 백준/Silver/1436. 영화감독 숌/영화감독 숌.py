# def ShomNumber(N):
#     n = 0
#     shomCount = 0
#     while True:
#         sixCount = 0
#         for i in str(n):
#             if i == '6':
#                 sixCount += 1
#             else:
#                 sixCount = 0
#             if sixCount >= 3:
#                 shomCount += 1
#                 break
#         if shomCount == N:
#             return n
#         n += 1

# N = int(input())
# print(ShomNumber(N))
# --> 1672ms, 30840kb, 395byte non-pythonic code

def ShomNumber(N):
    n = 1
    count = 0
    while True:    
        if '666' in str(n):
            count += 1
            if count == N:
                break
        n += 1
    return n
N = int(input())
print(ShomNumber(N))
## --> pythonic code