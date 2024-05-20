/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function (nums) {
    if (nums == null || nums.length == 0) return 0;
    return calculateXORSum(0, nums, 0);
};
/**
* @param {number} currIdx
* @param {number[]} nums
* @param {number} currXorSum
* @return {number}
*/
const calculateXORSum = (currIdx, nums, currXorSum) => {
    if (currIdx == nums.length) {
        return currXorSum;
    }
    const pick = calculateXORSum(currIdx + 1, nums, currXorSum ^ nums[currIdx]);
    const notPick = calculateXORSum(currIdx + 1, nums, currXorSum);
    return pick + notPick;
}