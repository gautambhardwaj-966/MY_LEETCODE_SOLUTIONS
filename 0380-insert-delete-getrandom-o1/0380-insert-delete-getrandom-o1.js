var RandomizedSet = function() {
    this.valToIndex = {}; // Object to store value to index mapping
    this.values = [];     // Array to store actual values
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    // If the value is already present, return false
    if (this.valToIndex.hasOwnProperty(val)) {
        return false;
    }

    // Add the value to the array and update its index in the object
    this.values.push(val);
    this.valToIndex[val] = this.values.length - 1;

    return true;
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    // If the value is not present, return false
    if (!this.valToIndex.hasOwnProperty(val)) {
        return false;
    }

    // Swap the value to remove with the last value in the array
    const lastValue = this.values.pop();
    const valIndex = this.valToIndex[val];

    if (valIndex < this.values.length) {
        this.values[valIndex] = lastValue;
        this.valToIndex[lastValue] = valIndex;
    }

    // Remove the value from the object
    delete this.valToIndex[val];

    return true;
};

/**
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    // Generate a random index and return the corresponding value
    const randomIndex = Math.floor(Math.random() * this.values.length);
    return this.values[randomIndex];
};

/** 
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
