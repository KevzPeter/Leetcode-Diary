class Solution:
    def minimumLength(self, s: str) -> int:
        map = {}
        for char in s:
            map[char] = map.get(char, 0) + 1
        ans = 0
        for key in map:
            if(map[key] >= 3 and map[key] % 2 == 1):
                map[key] = 1
            elif(map[key] >= 4 and map[key] % 2 == 0):
                map[key] = 2
            ans += map[key]
        return ans
        