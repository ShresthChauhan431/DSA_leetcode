class Solution {
public:
    void solve(int start,int end,int len,int sum,vector<int> &nums,map<int,set<int>> &mp){
        if(start == end){
            mp[len].insert(sum);
            return;
        }

        solve(start+1,end,len+1,sum+nums[start],nums,mp);
        solve(start+1,end,len,sum,nums,mp);
    }
    int minimumDifference(vector<int>& nums) {
        int n = nums.size();
        int mid = n/2;
        map<int,set<int>> mp1,mp2;
        int sum = accumulate(nums.begin(),nums.end(),0);

        solve(0,mid,0,0,nums,mp1);
        solve(mid,n,0,0,nums,mp2);

        int ans = 1e9;

        for(auto it:mp1){
            int needlen = mid - it.first;
            for(auto at:it.second){
                int a = at;
                int b = (sum-2*a)/2;

                auto mt = mp2[needlen].lower_bound(b);

                if(mt != mp2[needlen].end()){
                    int curr = *mt;
                    int sum1 = a+curr;
                    int sum2 = sum-sum1;

                    int diff = abs(sum1-sum2);

                    ans = min(ans,diff);
                }

                if(mt != mp2[needlen].begin()){
                    mt--;
                    int curr = *mt;
                    int sum1 = a+curr;
                    int sum2 = sum-sum1;

                    int diff = abs(sum1-sum2);

                    ans = min(ans,diff);
                }
            }
        }

        return ans;
    }
};