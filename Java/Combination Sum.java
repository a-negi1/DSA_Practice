class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  res = new ArrayList<>();

        int sum =0;
        solve(candidates,target,0,new ArrayList<>(),res,sum);
        return res;
    }

    void solve(int []arr,int target,int idx, List<Integer> currentPath ,List<List<Integer>>res,int sum){
        if(idx == arr.length){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(currentPath));
            return;
        }

        solve(arr,target,idx+1,currentPath,res,sum);

        if(arr[idx] +sum <=target){
            currentPath.add(arr[idx]);
            sum= sum + arr[idx];
            solve(arr,target,idx,currentPath,res,sum);
            currentPath.remove(currentPath.size()-1);
            sum = sum - arr[idx];
        }

    }
}