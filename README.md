# binary-search
Big Data assignmeny: binary search to find a given integer

## Problem

Create a text file of 1,000,000 random integers ranging also from 1 to 1,000,000. Then, load the integers into an array and perform the following:

a) perform a sequential search to find a given integer,
b) perform a binary search to find a given integer.

In both approaches, each time you visit a cell, write the corresponding integer on screen, and also count the total number of visited cells. Justify your findings.

## Solution

## Creating, Saving, and Reading Integer Values on a Text File

• A FileWriter class is used to create a text file.
• A for loop with condition i<=1000000 is used to keep adding random integers using java.util.Random class. Since the text file cannot have integer values equal to zero, r.nextInt(1000000)+1 command is used.
• A java.util.Scanner class is used to read integer values from the text file.

## Sequential Search

To perform sequential search on an array containing 1,000,000 integer values, the same Random class is first used to generate a random element number:
int searchFor = numbers[r.nextInt(1000000)];

This is to make sure that the value we are searching for is indeed found inside the array.

A simple for loop is then used to search sequentially (i.e. from element 0 and up):

In this method, 695,958 cells had to be visited before the number 990307 was found.

## Binary Search

Binary search uses a divide and conquer algorithm, under the condition that the array is sorted from lowest to highest value. For each unsuccessful search, half of the information available is rejected so that for the successive steps, the amount of data is reduced, thereby increasing the search speed.

The algorithm starts by comparing the given integer to the middle element in the array. If they are equal, then the search is complete. If the middle element is smaller than the given integer, the lower half of the array and the middle element is rejected. The search continues but only using the upper half of the array.

Otherwise, if the middle element is larger than the given integer, the search continues but only using the lower half of the array. This happens recursively until the desired integer is found.

In this method, it only took 17 cell visits to find the desired element.

## When Search Value is not Found

Clearly, the speed problem is even more pronounced in sequential search when the integer is not found as all array elements had to be searched. In binary search, it is still faster, as shown in the result below:

This result can be seen as worst-case scenario for binary search as it finished the search process without any result. Still, it only took 19 cell visits to find out that the value we are looking for is not in the array.

## Conclusion
• Binary search is significantly faster than sequential search
• Even for worst case scenario where the search returns nothing, binary search is still better
