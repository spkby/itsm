describe("1. Sort", function () {
    it("QuicSort [2, 1, 3] -> [1, 2, 3]", function () {
        var arr = [2, 1, 3];
        expect(quickSort(arr)).toEqual([1, 2, 3]);
    });
    it("QuicSort [3, 1, 2] -> [1, 2, 3]", function () {
        var arr = [3, 1, 2];
        expect(quickSort(arr)).toEqual([1, 2, 3]);
    });
    it("QuicSort [3, 2, 1] -> [1, 2, 3]", function () {
        var arr = [3, 2, 1];
        expect(quickSort(arr)).toEqual([1, 2, 3]);
    });
});

describe("2. BinarySearch", function () {
    it("[1, 2, 3] and 1 -> 0", function () {
        var arr = [1, 2, 3];
        expect(binarySearch(arr, 1)).toBe(0);
    });
    it("[1, 2, 3] and 2 -> 1", function () {
        var arr = [1, 2, 3];
        expect(binarySearch(arr, 2)).toBe(1);
    });
    it("[1, 2, 3] and 3 -> 2", function () {
        var arr = [1, 2, 3];
        expect(binarySearch(arr, 3)).toBe(2);
    });
    it("[1, 2, 3] and 3 -> 4", function () {
        var arr = [1, 2, 3];
        expect(binarySearch(arr, 4)).toBe(-1);
    });
});

describe("3. CheckSum", function () {
    it("[2, 1, 3] and 6 -> false", function () {
        var arr = [2, 1, 3];
        expect(checkSum(arr, 6)).toBe(false);
    });
    it("[2, 1, 3] and 2 -> true", function () {
        var arr = [2, 1, 3];
        expect(checkSum(arr, 5)).toBe(true);
    });
});