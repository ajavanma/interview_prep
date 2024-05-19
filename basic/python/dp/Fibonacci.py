def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1

    # Initialize an array to store Fibonacci numbers up to n
    arr = [0] * (n + 1)
    arr[0] = 0
    arr[1] = 1

    for i in range(2, n + 1):
        arr[i] = arr[i - 1] + arr[i - 2]

    return arr[n]  # Return the nth Fibonacci number
