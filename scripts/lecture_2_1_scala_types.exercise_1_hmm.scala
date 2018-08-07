// Can you explain these results?
scala> println { val x = if (false) 5 else '5' ; x }
53

scala> println { if (false) 5 else '5' }
5

// Answer:
// a) Immutable value x is type char that it is viewed as Int
// b) The block directly returns an Any that is converted into a string
