# Answe - 2

import sys

def fourSum(arr , n , target):
    arr.sort()
    found = False
    for i in range(n- 3):
        if i > 0 and arr[i] == arr[i- 1]:
            continue
        for j in range (i+ 1 , n - 2):
            if j > i + 1 and arr[j] == arr[j - 1]:
                continue
            left = j + 1
            right = n - 1
            while left < right:
                current_sum = arr[i] + arr[j] + arr[left] + arr[right]
                if current_sum == target:
                    print(f"{arr[i]} {arr[j]} {arr[left]} {arr[right]}")
                    found = True
                    while left < right and arr[left] == arr[left + 1]:
                        left += 1
                    while left < right and arr[right] == arr[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif current_sum < target:
                    left += 1
                else:
                    right -= 1
    if not found:
        print("No quadruplets found")

if __name__ == "__main__":
    n = int(input())
    arr = list(map(int, input().split()))
    target = int(input())
    fourSum(arr, n, target)
