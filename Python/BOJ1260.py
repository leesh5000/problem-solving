import sys
from collections import deque
from heapq import heappop, heappush
sys.setrecursionlimit(10**4)
sys.stdin = open("input.txt")
input = sys.stdin.readline

def DFS(V):
    if ck[V]==0:
        print(V, end=' ')
        ck[V]=1
        for next in list(sorted(graph[V])):
                DFS(next)

def BFS(V):
    dQ = deque()
    dQ.append(V)
    while dQ:
        cur = dQ.popleft()
        if ck[cur]==0:
            print(cur, end=' ')
            ck[cur]=1
            for next in list(sorted(graph[cur])):
                if ck[next]==0:
                    dQ.append(next)

if __name__ == "__main__":
    n,m,v = map(int, input().split())
    graph = [[] for i in range(n+1)]
    for _ in range(m):
        a,b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    ck = [0] * (n+1)
    DFS(v)
    ck = [0] * (n+1)
    print()
    BFS(v)