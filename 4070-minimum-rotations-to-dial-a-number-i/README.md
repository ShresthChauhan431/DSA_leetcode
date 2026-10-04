# 4070. Minimum Rotations to Dial a Number I

**Difficulty:** Easy

## Problem Statement

You are given a string `s` of length 10 consisting of digits.

The dial contains the digits 0 through 9 in order and is **circular**, so 0 and 9 are adjacent. The pointer initially points to 0.

To dial each digit of `s` **in order**, rotate the pointer until it points to that digit. Each rotation moves the pointer to an **adjacent** digit, and you may rotate in **either** direction. Dialing a digit that the pointer already points to requires no rotations.

Return the **minimum** total number of rotations needed to dial every digit of `s`.

 

**Example 1:**

**Input:** s = "0192837465"

**Output:** 25

**Explanation:**

StepFromToRotations10002011319249235284683573748743946210651

The total is `0 + 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1 = 25`, which is the minimum total number of rotations.

**Example 2:**

**Input:** s = "1200210200"

**Output:** 12

**Explanation:**

StepFromToRotations10112121320240005022621171018022920210000

The total is `1 + 1 + 2 + 0 + 2 + 1 + 1 + 2 + 2 + 0 = 12`, which is the minimum total number of rotations.

 

**Constraints:**

- `s.length == 10`

	- `s` consists only of digits `'0'` to `'9'`

## Sample Test Cases

### Example 1

**Input:**
```
s = "0192837465"
```

**Output:**
```
25
```

### Example 2

**Input:**
```
s = "1200210200"
```

**Output:**
```
12
```
