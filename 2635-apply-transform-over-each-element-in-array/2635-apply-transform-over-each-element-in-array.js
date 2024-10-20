/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const result = [];
    for(i=0;i<=arr.length-1;i++){
        result.push(fn(arr[i],i));
    }
    return result;
};