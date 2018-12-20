// sort
function runQuickSort(arr, start, end) {
    if (start < end) {

        let i = start;
        let j = end;

        let pivot = parseInt(i - (i - j) / 2);

        while (i < j) {
            while ((i < pivot) && (arr[i] <= arr[pivot])) { i++; }
            while ((j > pivot) && (arr[j] >= arr[pivot])) { j--; }

            if (i < j) {
                let tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                if (i == pivot) { pivot = j; } else if (j == pivot) { pivot = i; }
            }
        }

        runQuickSort(arr, start, pivot);
        runQuickSort(arr, pivot + 1, end);
    }
    return arr;
}

function quickSort(unsortedArray) {
    return runQuickSort(unsortedArray, 0, unsortedArray.length - 1);
}

// binary search
function runBinarySearchRecursively(arr, key, low, high) {
    let middle = parseInt((low + high) / 2);

    if (high < low) {
        return -1;
    }

    if (key == arr[middle]) {
        return middle;
    } else if (key < arr[middle]) {
        return runBinarySearchRecursively(arr, key, low, middle - 1);
    } else {
        return runBinarySearchRecursively(arr, key, middle + 1, high);
    }
}

function binarySearch(sortedArray, key) {
    return runBinarySearchRecursively(sortedArray, key, 0, sortedArray.length - 1);
}

// check to sum
function checkSum(arr, sum) {

    let sortedArray = quickSort(arr, 0, arr.length - 1);

    for (let i = 0; i < sortedArray.length; i++) {
        let index = binarySearch(sortedArray, sum - sortedArray[i]);
        if (-1 != index && index != i) {
            return true;
        }
    }
    return false;
}