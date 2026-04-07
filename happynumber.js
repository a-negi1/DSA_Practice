/**
 * @param {number} n
 * @return {boolean}
 */

var number = (a) => {
    let sum = 0;
    while (a > 0) {
        let d = a % 10;
        sum += d * d;
        a = Math.floor(a / 10);
    }
    return sum;
};

var isHappy = function(n) {
    let slow = n;
    let fast = n;

    while (true) {
        slow = number(slow);
        fast = number(number(fast));

        if (slow === fast) {
            break;
        }
    }

    return slow === 1;
};