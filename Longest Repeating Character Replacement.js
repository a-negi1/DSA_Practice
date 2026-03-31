function find(arr) {
    let maxc = -1;
    for (let i = 0; i < 256; i++) {
        maxc = Math.max(maxc, arr[i]);
    }
    return maxc;
}

var characterReplacement = function (s, k) {
    let n = s.length;
    let f = new Array(256).fill(0);

    let low = 0;
    let res = -Infinity;

    for (let high = 0; high < n; high++) {
        f[s.charCodeAt(high)]++;

        let maxcnt = find(f);
        let len = high - low + 1;
        let diff = len - maxcnt;

        while (diff > k) {
            f[s.charCodeAt(low)]--;
            low++;

            maxcnt = find(f);
            len = high - low + 1;
            diff = len - maxcnt;
        }

        len = high - low + 1;
        res = Math.max(res, len);
    }

    return res;
};