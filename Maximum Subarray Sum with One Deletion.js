var maximumSum = function(a) {
    let n = a.length;
    let noDel = a[0];
    let oneDel = -Infinity;
    let res = a[0];

    for (let i = 1; i < n; i++) {
        let prevNoDel = noDel;

        noDel = Math.max(a[i], noDel + a[i]);

        oneDel = Math.max(prevNoDel, oneDel + a[i]);

        res = Math.max(res, Math.max(noDel, oneDel));
    }

    return res;
};