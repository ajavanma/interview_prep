package leetcode.easy.java;

// Given a string s consisting of words and spaces, return the length of the last word in the string.
// * A word is a maximal substring consisting of non-space characters only.


class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");  
        return words[words.length - 1].length();              
    }
}

// s.trim():       trims any leading or trailing whitespace from the input string
// split("\\s+"):  uses a regular expression to split the string around sequences of one or more whitespace characters. It results in an array of words
//                 \  escape
//                 \s matches any whitespace character
//                 +  matches one or more of the preceding element
// words[words.length - 1]: accesses the last element in the array, which is the last word
