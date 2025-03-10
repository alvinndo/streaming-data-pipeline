package com.labs1904.hwe.exercises

object ChallengeProblems {
  /**
    1. Define a function that takes in a String and returns that string with no changes
    Write your function below this comment - refer to Challenge Tests to have your test pass
    Params - String
    Returns - String
  */
  def sameString(input: String): String = {
    input
  }

  /**
  2. Write a function that returns "Hello World!" and takes in nothing as a parameter
  Params - None
  Returns - String
   */
  def helloWorld(): String = {
    "Hello World!"
  }

  /**
  3. Write a function that takes in a list and returns the total size of the list
  -Note - Use the .size method
  Params - List[Int]
  Returns - Int
   */
  def listSize(input: List[Int]): Int = {
    input.size
  }

  /**
  4. Write a function that takes in an int and adds an int that you create within the function and returns the addition of the two together
  Note - Your variable must be a val and must be equal to 25
  Params - Int
  Returns - Int
   */
  def sumInts(input: Int): Int = {
    val addInt: Int = 25
    input + addInt
  }

  /**
   5. Write a function that takes in a list of strings, and return a list of strings where every letter is capitalized
   Hint - you can use .map here
   Params - List[String]
   Returns - List[String]
*/
  def upper(input: List[String]): List[String] = {
    input.map((x: String) => x.toUpperCase())
  }

  /**
  6. Write a function that returns a new list, where only elements of the list passed in that are 0 or positive numbers are kept.
  Params - List[Int]
  Returns - List[Int]
   */
  def filterNegatives(input: List[Int]): List[Int] = {
    input.filter( (x: Int) => x >= 0 )
  }

  /**
  7. Returns a new list, where only the elements passed in containing "car" are kept to the new list.
  Params - List[String]
  Returns - List[String]
 */
  def containsCar(input: List[String]): List[String] = {
    input.filter( (x: String) => x.contains("car") )
  }

  /**
    8. Returns the sum of all numbers passed in.
    Params - List[Int]
    Returns - Int
   */
  def sumList(input: List[Int]): Int = {
    input.sum
  }

  /**
  9. Write a function that takes in an integer with a cats age, and return the human age equivalent.
    A human year is equivalent to 4 cat years
    Params - Int
    Returns - Int
   */
  def catsAge(input: Int): Int = {
    val catAge: Int = 4
    input * catAge
  }

  /**
  10. Same question as #9, but this time you are given a Option[Int]
    If an int is provided, returns a cats age for the human's age equivalent.
    If None is provided, return None
    A humanYear is equivalent to four catYears
    -Params - Option[Int]
    -Returns - Option[Int]
 */
  def catsAgeOption(input: Option[Int]): Option[Int] = {
    input.map( (x: Int) => x * 4 )
  }

  /**
  11. Write a function that takes in a list of ints, and return the minimum of the ints provided
  Params - List
  Returns - Int
   */
  def minimum(input: List[Int]): Int = {
    input.min
  }

  /**
  12. Same as question 11, but this time you are given a list of Option[Ints], returns the minimum of the Ints provided.
  If no ints are provided, return None.
 */
  def minimumOption(input: List[Option[Int]]): Option[Int] = {
    input.min
  }

}
