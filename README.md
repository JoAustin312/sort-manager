# Java Sort Manager
This is a program which allows the user to choose from a number of sorting algorithms and sort a
randomly generated an array, the size of which is chosen by the user.

There are 4 sorting algorithms to choose from:

1. Bubble Sort
2. Merge Sort
3. Insertion Sort
4. Tree Sort (Binary Tree Sort)

### The steps the user must take to use the program are as follows:
```
Enter any number except 0 to continue (0 will exit the program)
```
```
Please choose a sorter by entering the corresponding value below: 
1: Bubble Sort
2: Merge Sort
3: Insertion Sort
4: Tree Sort
```
```
Please enter a number for the size of the array to be generated
```
The user will then be presented with an output such as:
```bash
 ---------- RESULTS ---------- 

Unsorted Array: 
[348, 614, 203, 418, 98, 795, 817, 327, 55, 742, 364, 704, 273, 510, 219, 484, 134, 236, 713, 398, 947, 522, 759, 624, 1, 573, 501, 142, 764, 175, 787, 68, 454, 428, 774, 804, 409, 934, 319, 368, 993, 919, 989, 584, 439, 426, 930, 889, 578, 311, 531, 179, 311, 305, 681, 428, 570, 886, 933, 278, 357, 162, 593, 74, 477, 336, 297, 24, 508, 271, 32, 485, 976, 436, 422, 279, 219, 122, 855, 151, 740, 410, 463, 307, 610, 385, 354, 415, 193, 389, 304, 167, 597, 179, 701, 508, 523, 808, 383, 633]

Array after using TreeSorter:
[1, 24, 32, 55, 68, 74, 98, 122, 134, 142, 151, 162, 167, 175, 179, 179, 193, 203, 219, 219, 236, 271, 273, 278, 279, 297, 304, 305, 307, 311, 311, 319, 327, 336, 348, 354, 357, 364, 368, 383, 385, 389, 398, 409, 410, 415, 418, 422, 426, 428, 428, 436, 439, 454, 463, 477, 484, 485, 501, 508, 508, 510, 522, 523, 531, 570, 573, 578, 584, 593, 597, 610, 614, 624, 633, 681, 701, 704, 713, 740, 742, 759, 764, 774, 787, 795, 804, 808, 817, 855, 886, 889, 919, 930, 933, 934, 947, 976, 989, 993]

Time taken to sort: 34000 ns

---------- END ----------
```

As evidenced in the above output, each sorting algorithm is timed in nanoseconds. This allows the user to
see exactly how fast each sorter is when sorting a random array of integers.

## How it works
1. The user enters any number except 0 to start the program
    * This is for the while loop and allows the user to use the program consecutively
2. User input is taken for the chosen sorter in the form of a number ranging from 1-4 (inclusive)
   * If the given number is outside this range, a `SorterNotFoundException` is thrown
3. A sorter object is retrieved from a sorter factory based on the user input
4. User input is taken again, this time for the size of the array to be randomly generated
5. An array is randomly generated based on given size
6. The array is passed to the chosen sorter to be sorted
    * This is where the algorithm is timed by calling `System.nanotime()` before and after the `sortArray()` method and 
   calculating the result
7. The sorted array is then printed alongside the unsorted array, the type of sorter used and the time taken to sort
8. The user is again then asked to enter any number except 0 or enter 0 to exit

### Binary Tree
Within the `BinaryTree` class there is functionality for:
* Creating the binary tree with 3 overloaded constructors 
    * `BinaryTree(final int element)` for creating a tree with just a root node
    * `BinaryTree(int[] arr)` for creating a tree with an array
    * `BinaryTree(final int element, int[] arr)` for creating a tree from an array with a specified root node
* Adding individual elements 
* Checking whether a specified value is in the tree
* Retrieving a specific node from the tree with a given value
* Getting the number of elements currently in the tree
* Adding multiple nodes to the tree from an array
* Getting the left and right children of the specified element/node
* Retrieving a sorted array of all values in the tree (ascending/descending)

### Exceptions
There are three custom exceptions in this project:
* `ChildNotFoundException` - This is thrown inside the `getLeftChild(int)` or `getRightChild(int)` methods if the `hasLeftChild()` or `hasRightChild()` methods in `Node` returns false
* `NodeNotFoundException` - This is also thrown inside the `getLeftChild(int)` or `getRightChild(int)` methods, but this time if the `findElement(int)` method returns false
* `SorterNotFoundException` - As previously mentioned, this is thrown if the user input for choosing a sorter is not valid

### Logging
Using the Java in-built logging framework, there is logging throughout the main functions of the program. The only exception to this is the logic of the sorting algorithms, as the process of logging the action would affect the results of the timer.

The intention of the logger is to document each step of the processes above, and as such there is only once instance of a logger that is passed around using the `static getLogger()` method in the `MyLogger` class and only writes to one log file.



