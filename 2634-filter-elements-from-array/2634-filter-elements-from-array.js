/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const array = [];
    for(let i=0;i<=arr.length-1;i++){
    if(fn(arr[i],i)){
        array.push(arr[i])
    }
    }
    return array;
};