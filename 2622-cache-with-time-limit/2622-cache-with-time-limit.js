var TimeLimitedCache = function() {
    this.cache = new Map(); // Map to store key-value pairs with expiration information
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const currentTime = Date.now();

    // Check if an unexpired key already exists
    const hasUnexpiredKey = this.cache.has(key) && this.cache.get(key).expiry > currentTime;

    // Clear any existing timeout for the key
    if (this.cache.has(key)) {
        clearTimeout(this.cache.get(key).timeoutId);
    }

    // Set a new timeout to delete the key when it expires
    const timeoutId = setTimeout(() => {
        this.cache.delete(key);
    }, duration);

    // Store the key with value, expiry time, and timeoutId
    this.cache.set(key, { value, expiry: currentTime + duration, timeoutId });

    return hasUnexpiredKey;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const currentTime = Date.now();

    // Check if the key exists and is unexpired
    if (this.cache.has(key) && this.cache.get(key).expiry > currentTime) {
        return this.cache.get(key).value;
    } else {
        return -1; // Return -1 if the key doesn't exist or is expired
    }
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    const currentTime = Date.now();
    let count = 0;

    // Count only the non-expired keys
    for (const [key, data] of this.cache) {
        if (data.expiry > currentTime) {
            count++;
        }
    }

    return count;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */