# Java Sort Manager
This is a program which allows the user to choose from a number of sorting algorithms and sort a
randomly generated an array, the size of which is chosen by the user.

There are 4 sorting algorithms to choose from:

1. Bubble Sort
2. Merge Sort
3. Insertion Sort
4. Tree Sort (Binary Tree Sort)

### The steps the user must take to use the program are as follows:
```bash
Enter any number except 0 to continue (0 will exit the program)

Please choose a sorter by entering the corresponding value below: 
1: Bubble Sort
2: Merge Sort
3: Insertion Sort
4: Tree Sort

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

### Other features:

* Custom exceptions
    * ChildNotFoundException
    * NodeNotFoundException
    * SorterNotFoundException
* Logging for the whole program (apart from inside sorting algorithms)
* Factory for creating each of the sorters

