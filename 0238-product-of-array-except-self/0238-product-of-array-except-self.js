/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const n = nums.length;

    // Initialize left and right product arrays
    const leftProducts = new Array(n).fill(1);
    const rightProducts = new Array(n).fill(1);

    // Calculate left products
    let leftProduct = 1;
    for (let i = 1; i < n; i++) {
        leftProduct *= nums[i - 1];
        leftProducts[i] = leftProduct;
    }

    // Calculate right products
    let rightProduct = 1;
    for (let i = n - 2; i >= 0; i--) {
        rightProduct *= nums[i + 1];
        rightProducts[i] = rightProduct;
    }

    // Calculate the final result
    const result = [];
    for (let i = 0; i < n; i++) {
        result[i] = leftProducts[i] * rightProducts[i];
    }

    return result;
};