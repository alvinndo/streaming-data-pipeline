val myStates = Map(
  "MO" -> "The Arch",
  "IL" -> "The Bean",
  "OH" -> "The Ohio State University",
  "CA" -> "Disneyland",
  "FL" -> "Disney World",
  "IN" -> "Some random gas station"
)

val visitedPlaces = List("MO", "FL", "IL", "IN", "OH", "CA")

visitedPlaces.map(place => myStates(place))








val directionalStates = List(
  "West Virginia",
  "North Dakota",
  "South Dakota",
  "North Carolina",
  "South Carolina",
  "West Virginia"
)

val nums: List[Int] = List(
  1,
  2,
  3,
  4
)

// map, filter, foldLeft, flatMap, flatten



// In another language, you might :
for (n <- nums) {
  // Multiply each number by 7
}
