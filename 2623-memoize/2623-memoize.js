/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
  const cache = new Map(); // To store results
  let callCount = 0; // To track the number of times fn is actually called

  return function(...args) {
    const key = JSON.stringify(args); // Serialize arguments as key for cache

    // If the result for these arguments is in the cache, return it
    if (cache.has(key)) {
      return cache.get(key);
    }

    // Otherwise, call the function and store the result in cache
    callCount++;
    const result = fn(...args);
    cache.set(key, result); // Cache the result
    return result;
  };
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */