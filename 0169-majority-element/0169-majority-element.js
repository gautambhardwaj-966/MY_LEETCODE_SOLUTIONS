/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let half = nums.length/2;
    let map={};
    for(let i=0;i<nums.length;i++){
        map[nums[i]]=(map[nums[i]]|0)+1;
        if(map[nums[i]]>half){
            return nums[i];
        }
    }
};