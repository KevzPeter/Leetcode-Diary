function maxSatisfied(customers: number[], grumpy: number[], minutes: number): number {
    const len = customers.length;
    let satisfied = customers.reduce((acc, curr, idx) => acc += grumpy[idx] == 0 ? curr : 0, 0);
    let start = 0, end = start, currWindow = 0;
    // creating initial window
    while (end < minutes) {
        if (grumpy[end] == 1) {
            currWindow += customers[end];
        }
        end++;
    }
    let maxWindow = currWindow;
    // sliding window until end
    while (end < len) {
        if (grumpy[end] == 1) {
            currWindow += customers[end];
        }
        if (grumpy[start] == 1) {
            currWindow -= customers[start];
        }
        maxWindow = Math.max(maxWindow, currWindow);
        end++;
        start++;
    }
    return satisfied + maxWindow;
};