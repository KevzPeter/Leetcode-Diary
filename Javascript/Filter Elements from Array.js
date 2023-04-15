/**
 * Given an integer array arr and a filtering function fn, return a new array with a fewer or equal number of elements.
 * The returned array should only contain elements where fn(arr[i], i) evaluated to a truthy value.
 * Please solve it without the built-in Array.filter method.
 */

// Without using filter()

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
    let res = [];
    arr.forEach((num, index) => {
        if (fn(num, index)) {
            res.push(num);
        }
    })
    return res;
};

// Using filter()

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */

var filter = (arr, fn) => arr.filter((num, index) => fn(num, index));