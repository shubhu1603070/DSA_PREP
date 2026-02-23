class Solution {
public:

    int t[1001][1001];
    bool palin(string &s,int i,int j){
      if(i >= j) return true;
      if(t[i][j] != -1) return t[i][j];
      if(s[i] != s[j]) return false;
      return t[i][j] = palin(s,i+1,j-1);
    }

    string longestPalindrome(string s) {
        int n = s.length();
        int maxLen = INT_MIN;
        int sp = 0;
        memset(t,-1,sizeof(t));
        for(int i = 0;i<n;i++){
          for(int j = i;j<n;j++){
            if(t[i][j] == 1 || palin(s,i,j) == true){
              if( j - i + 1 > maxLen){
                maxLen = (j-i+1);
                sp = i;
              }
            }
          }
        }
      return s.substr(sp,maxLen);
    }

};