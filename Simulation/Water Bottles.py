class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        ans = numBottles
        while(numBottles >= numExchange):
            newBottles = (numBottles // numExchange)
            ans = ans + newBottles
            numBottles = newBottles + (numBottles % numExchange)
        return ans
        