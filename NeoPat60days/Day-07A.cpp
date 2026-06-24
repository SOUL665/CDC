// DSA
// Answer - 1

#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

void merge_sort(vector<int>& indices, const vector<int>& nums, vector<int>& result, int left , int right){
    if (right-left <= 1)return;
    
    int mid = left+ (right - left)/2;
    merge_sort(indices, nums , result , left , mid);
    merge_sort(indices, nums , result , mid , right);
    
    vector<int>merged;
    int i = left , j = mid;
    int smaller_count = 0;
    
    while(i< mid && j< right){
        if (nums[indices[j]] < nums[indices[i]]){
            smaller_count++;
            merged.push_back(indices[j++]);
        }
        else{
            result[indices[i]] += smaller_count;
            merged.push_back(indices[i++]);
        }
    }
    
    while (i < mid){
        result[indices[i]] += smaller_count;
        merged.push_back(indices[i++]);
    }
    while(j<right){
        merged.push_back(indices[j++]);
    }
    
    for (int k=0 ; k<merged.size(); k++){
        indices[left+k] = merged[k];
    }
}

int main(){
    int n;
    if(!(cin>> n)) return 0 ;
    
    vector<int> nums(n);
    vector<int> indices(n);
    vector<int> result(n , 0);
    
    for(int i = 0; i<n; i++){
        cin >> nums[i];
        indices[i] = i;
    }
    
    merge_sort(indices , nums , result , 0 , n);
    
    for(int i = 0 ; i<n;i++){
        cout << result[i] << (i == n-1 ?" " : " ");
    }
    cout <<endl;
    
    return 0;
}
