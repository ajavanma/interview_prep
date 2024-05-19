#  It should take a list of our players' inventory (strings) as input and return the number of times Healing potion shows up in the list as an integer.
def count_potions(inventory):
    count = 0
    for potion in inventory:
        if potion == "Healing potion":
            count +=1
    return count             # pay attention to the indentation to be correct after the for loop



# find the last item in their inventory.
def last_item(inventory):
    return inventory[-1] if inventory else None

# second approach:
def last_item(inventory):
    if len(inventory) > 0:
        return inventory[len(inventory) - 1]



# Stack
# stack.push(item) -> places a new item on top of the stack
# stack.pop() -> removes the top item from the stack and returns it
# stack.peek() -> returns the top item from the stack without modifying the stack
# stack.size() -> returns the number of items in the stack

# implementing stack with a list 
#  Python lists are dynamic arrays internally
class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)
    
    def pop(self):
        return self.items.pop() if self.items else None   # .pop() : removes and returns the last item added to the list: here LIFO
    
    # def pop(self):
    #     if len(self.items) == 0:
    #         return None
    #     return self.items.pop()

    def peek(self):
        return self.items[-1] if self.items else None
        # return self.items[len(self.items)-1] if self.items else None

    def size(self):
        return len(self.items)



##
# using stack for organizing the function calls ourselves:
##
def attack_action():
    call(shoot_arrow)
    call(calc_new_health)

def shoot_arrow():
    call(calc_damage)

def calc_damage():
    call(apply_damage)

def calc_new_health():
    pass

def apply_damage():
    pass

class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if len(self.items) == 0:
            return None
        return self.items.pop()

    def peek(self):
        if len(self.items) == 0:
            return None
        return self.items[len(self.items) - 1]
    
    def size(self):
        return len(self.items)


stack = Stack()

def call(func):
    stack.push(func.__name__)
    print("Pushing " + func.__name__)
    print("Stack: " + str(stack.items))
    print("=================================")
    func()
    stack.pop()
    print("Popping " + func.__name__)
    print("Stack: " + str(stack.items))
    print("=================================")

call(attack_action)




# Stack overflow:
# A REAL STACK OVERFLOW
# A stack overflow occurs if the number of calls in the stack exceeds the limit. The limit depends on many factors, including the programming language,
# machine architecture, multi-threading, and the amount of available memory. When a program goes over the limit, that stack is said to overflow which 
# typically results in the program crashing.

# Python, unlike lower-level languages like C, prevents the interpreter stack from growing so large that a stack overflow occurs.
# Instead, a runtime exception is thrown.



# ASSIGNMENT
# Write a function is_balanced(input_str) that takes a string input_str as input and returns True if the parentheses in the string are balanced, and False otherwise. Use a stack to keep track of the parentheses.
# Note: You only need to consider the characters ( and ) for this challenge.
# TIP
# We've created a class named Stack with some helpful functions that you can use to complete the is_balanced function.

def is_balanced(input_str):
    s = Stack()
    for char in input_str:
        if char == '(':
            s.push(char)         # Push all opening parentheses onto the stack
        elif char == ')':
            if s.pop() is None:  # If there's no matching opening parenthesis
                return False     # Unbalanced
    return s.size() == 0         # Check if the stack is empty at the end


# improved version to include other brackets
def is_balanced(input_str):
    s = Stack()
    matching_bracket = {')': '(', ']': '[', '}': '{'}  # Map closing brackets to their corresponding opening brackets

    for char in input_str:
        if char in matching_bracket.values():       # If the character is an opening bracket
            s.push(char)                            # Push onto the stack
        elif char in matching_bracket:              # If the character is a closing bracket
            if s.pop() != matching_bracket[char]:   # Check if the top of the stack matches the expected opening bracket (value of the matching_bracket dictionary)
                return False                        # Unbalanced if it doesn't match
    return s.size() == 0                            # Check if the stack is empty at the end


# second approach of the improved version
def is_balanced(input_str):
    s = Stack()
    matching_bracket = {'(': ')', '[': ']', '{': '}'}  # Map opening brackets to their corresponding closing brackets

    for char in input_str:
        if char in matching_bracket:                # If the character is an opening bracket
            s.push(char)                            # Push it onto the stack
        elif char in matching_bracket.values():     # If the character is a closing bracket
            # checking if the stack is not empty when we are using the values to iterate is necessary unlike when we are using the keys
            if s.size() == 0 or char != matching_bracket[s.pop()]:  # Check if the stack is empty or the closing bracket does not match
                return False                        # Unbalanced if it doesn't match
            # if s.size() == 0:  
                # return False  # If empty, it's unbalanced because there's no opening bracket for this closing one
            # if char != matching_bracket[s.pop()]:  # Pop the top and check if it does not match the expected opening bracket
            #     return False  # It's unbalanced if the closing bracket does not match the opening one
    return s.size() == 0                            # The stack should be empty if all brackets are balanced







# ASSIGNMENT
# Complete the PotionStack class. It should inherit from the Stack class.
# Override the .push() method in the PotionStack class. If the potion on the top of the stack is of the same type as the potion being pushed, 
# then the push operation fails and nothing happens. Otherwise, use the .push() method of the Stack class to push the potion onto the stack.

class PotionStack(Stack):
    def push(self, item):
        if self.peek() == item:
            return

        super().push(item)      # Otherwise, call the original push method to add the item to the stack
