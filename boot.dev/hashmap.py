
# Let's build a toy hash map in Python. In the real world, you would almost always use the built-in dictionary if you need a hash map. 
# Let's build a hashmap that maps real names to character names.

class HashMap:
    
    def __init__(self, size):
        self.size = size 		                    # include this in the constructor or use len(self.hashmap)
        self.hashmap = [None for i in range(size)]  # list comprehension: create a list of "size" length with None values, assign it to hashmap attribute of the current object

    # It provides a list of just the values that are currently stored in the hashmap without indicating their positions (indexes). 
    # This makes it harder to see at a glance where collisions might occur or how spread out the data is across the hashmap.
    def __repr__(self):                     # representing the state of the hashmap, This version only lists non-empty buckets, skipping over None values entirely.
        buckets = []
        for v in self.hashmap:
            if v != None:
                buckets.append(v)
        return str(buckets)
    
    # Given a string representing one Unicode character, return an integer representing the Unicode code point of that character. 
    # For example, ord('a') returns the integer 97 and ord('€') (Euro sign) returns 8364. This is the inverse of chr().
    def key_to_index(self, key):            #  hashing function

        sum_unicode = 0
        for char in key:
            sum_unicode += ord(char)        # Sum all the Unicode values of the characters in the key
        
        index = sum_unicode % self.size     # Use modulo as hashmap 
        
        return index                        # return sum % len(self.hashmap)  




# The hashmap list will look something like this:

# [
#     (key, val),
#     None,
#     None,
#     (key, val),
#     None,
#     ...
# ]

class HashMap:
    def __init__(self, size):
        self.hashmap = [None for i in range(size)]

    # lists every index in the hashmap, regardless of whether it contains data or not, good for debugging(output could be filled with Nones)
    def __repr__(self):                 
        final = ""
        # The __next__() method of the iterator returned by enumerate() returns a tuple containing a count 
        # (from start which defaults to 0) and the values obtained from iterating over iterable. (count, not index)
        for i, v in enumerate(self.hashmap):  
            if v is not None:
                final += f"{i}: {str(v)}\n"
            else:
                final += f"{i}: None\n"
        return final
    
    def key_to_index(self, key):                 # Calculate the index for the key
        sum = 0
        for c in key:
            sum += ord(c)
        return sum % len(self.hashmap)
    
    def insert(self, key, value):
        index = self.key_to_index(key) 
        self.hashmap[index] = (key, value)       # Insert the (key, value) tuple at the calculated index

    def get(self, key):
        index = self.key_to_index(key)  
        if self.hashmap[index] is not None:
            return self.hashmap[index][1]        # Return the value associated with the key : Each entry in the table is actually a combination of the three values: hash, key, value
        raise Exception("sorry, key not found")  # Key not found or collision unresolved
    
    # alternative
    def get(self, key):
            i = self.key_to_index(key)
            bucket = self.hashmap[i]
            if bucket is None:
                raise Exception("sorry, key not found")
            return bucket[1]






# Dictionary: build-in hash tables
#  keys can be any immutable type
# even tuples can be used as keys if they contain only strings, numbers, or tuples
# a set of key: value pairs, with the requirement that the keys are unique
my_dict = {"wonder": "woman", "super": "man", "spider": "man"}

# dict comprehension: {key: value for key, value in iterable}
{x: x ** 2 for x in range(10)}

# dic constructor: dict(key=value, key=value)
dic2 = dict(foo=100, bar=200)
# dic constructor: dict([(key, value), (key, value)])
dic1 = dict([('foo', 100), ('bar', 200)])



# set:
# unordered collection with no duplicate elements
# Basic uses include membership testing and eliminating duplicate entries. 
# Set objects also support mathematical operations like union, intersection, difference, and symmetric difference.
my_set = set(["all", "these", "items", "are", "unique"])

basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)  # duplicates are removed: {'orange', 'banana', 'pear', 'apple'}
'orange' in basket   # True



# Tuple
# immutable sequence of values, typically used to store collections of heterogeneous data 
my_tuple = ("string", 5, True)
# ways to create a tuple
# ()
# (a,)
# (a, b, c)
# tuple()

# Note that it is actually the comma which makes a tuple, not the parentheses.
# The parentheses are optional, except when they are needed to avoid syntactic ambiguity, eg. function call (arguments) and empty tuple









# RESIZING
# In the current implementation of HashMap, our hashmap has a lot of collisions. This is because we are using a fixed size for our hashmap.
# To reduce the chances of a collision, we can increase the number of slots (buckets?) in our hashmap. This is called resizing.
# When resizing, we create a new hashmap with a larger number of slots. Then, we re-insert all the key-value pairs from the old hashmap into the new hashmap.

# ASSIGNMENT
# Complete the following methods.

# CURRENT_LOAD()
# This method returns the number of filled buckets in the hashmap as a percentage of the total number of buckets.

# If the length of the underlying list is zero, return 1. Otherwise, divide the number of filled buckets by the length of the underlying list and return it.

# RESIZE()
# If the length of the underlying hashmap is 0, make the length 1 (by just adding a None entry).

# Get the current load. If it's less than 5%, do nothing, we have plenty of space.

# Otherwise, create a new empty hashmap that's 10x the size of the current one, then use the insert method to re-insert all the key-value pairs from the old hashmap into the new one.

# INSERT()
# Call resize() before inserting to make sure there's enough space. Then, insert the key-value pair into the hashmap as normal.

class HashMap:
    def __init__(self, size):
        self.hashmap = [None for i in range(size)]

    def key_to_index(self, key):
        sum = 0
        for c in key:
            sum += ord(c)
        return sum % len(self.hashmap)

    def __repr__(self):
        final = ""
        for i, v in enumerate(self.hashmap):
            if v != None:
                final += f" - {str(v)}\n"
        return final


    def insert(self, key, value):
        self.resize()              # Check if resizing is needed before inserting
        index = self.key_to_index(key)
        # Insert logic as previously defined, assuming no collision handling
        self.hashmap[index] = (key, value)

    def resize(self):
        if len(self.hashmap) == 0:   # hashmap is initially empty
            self.hashmap = [None]    # make the length 1 (by just adding a None entry)
            return
        
        load_factor = self.current_load()
        if load_factor < 0.05:
            return  
        
        # Create a new hashmap 10x the size of the current
        new_size = 10 * len(self.hashmap)
        new_hashmap = [None] * new_size
        
        # Re-insert existing entries into the new hashmap
        old_hashmap = self.hashmap
        self.hashmap = new_hashmap
        for item in old_hashmap:
            if item is not None:
                self.insert(item[0], item[1])  # Re-insert each item

    def current_load(self):
        if len(self.hashmap) == 0:
            return 1
        # generator expression: For each filled bucket, the generator yields 1. The sum() function then adds up all these 1s, resulting in the total number of filled buckets
        filled_buckets = sum(1 for item in self.hashmap if item is not None) 
        return filled_buckets / len(self.hashmap)




















