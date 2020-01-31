# Find the smallest
# 
# You have a positive number n consisting of digits. You can do at most one operation:
# Choosing the index of a digit in the number, remove this digit at that index and insert it back to another
# or at the same place in the number in order to find the smallest number you can get.
# 
# #Task: Return an array or a tuple or a string depending on the language (see "Sample Tests") with
# 
# 1) the smallest number you got
# 2) the index i of the digit d you took, i as small as possible
# 3) the index j (as small as possible) where you insert this digit d to have the smallest number.
# Example:
#   
#   smallest(261235) --> [126235, 2, 0] or (126235, 2, 0) or "126235, 2, 0"
# 126235 is the smallest number gotten by taking 1 at index 2 and putting it at index 0
# 
# smallest(209917) --> [29917, 0, 1] or ...
# 
# [29917, 1, 0] could be a solution too but index `i` in [29917, 1, 0] is greater than 
# index `i` in [29917, 0, 1].
# 29917 is the smallest number gotten by taking 2 at index 0 and putting it at index 1 which gave 029917 which is the number 29917.
# 
# smallest(1000000) --> [1, 0, 6] or ...
# Note
# Have a look at "Sample Tests" to see the input and output in each language


smallest <- function(n) {
  digits <- unlist(strsplit(toString(n), ""))
  perms <- lapply(seq(1, length(digits), 1), function(d1){
    lapply(seq(1, length(digits), 1), function(d2){
      paste(append(digits[-d1], digits[d1], after = d2-1), collapse = "")
    })
  })
  indices <- lapply(seq(1, length(digits), 1), function(d1){
    lapply(seq(1, length(digits), 1), function(d2){
      toString(c(d1, d2))
    })
  })
  smallest <- as.numeric(min(unlist(perms)))
  ij <- as.numeric(unlist(strsplit(unlist(indices)[grep(smallest, unlist(perms))[1]], ", ")))
  c(smallest, ij)
}


## Note: this solution works for all but a few tests where nchar(n) is >= 10. Waiting for author to include n in error prompt.

smallest(261235) == c(126235, 3, 1)
smallest(209917) == c(29917, 1, 2)