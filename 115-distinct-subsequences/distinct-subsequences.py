class Solution:
    dp=[]
    def solve(self,i,j,s,t):
        if j>=len(t):
            return 1
        if i>=len(s):
            return 0
        cnt=0
        if self.dp[i][j]!=-1:
            return self.dp[i][j]
        if(s[i]==t[j]):
            cnt+=self.solve(i+1,j+1,s,t)
        cnt+=self.solve(i+1,j,s,t)
        self.dp[i][j]=cnt
        return cnt
  
    def numDistinct(self, s: str, t: str) -> int:
        self.dp = [[0] * len(t) for _ in range(len(s))]
        for i in range(0,len(s)):
            for j in range(0,len(t)):
                self.dp[i][j]=-1

        return self.solve(0,0,s,t)

        