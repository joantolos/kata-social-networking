# kata-tic-tac-toe

Implement the tic-tac-toe game on Console with two human players.

# Constraints

The game should be implemented using TDD. To make the kata interesting, there are two constraints to take into account

## Two minutes iteration

Set a clock timer to two minutes. When the alarm sounds, pass all your tests, if they don't pass, revert the changes to the last commit:

    git reset --hard

## Object Calisthenics

Object Calisthenics are programming exercises, formalized as a set of 9 rules invented by Jeff Bay in his book The ThoughtWorks Anthology. The word Object is related to Object Oriented Programming. The word Calisthenics is derived from greek, and means exercises under the context of gymnastics. By trying to follow these rules as much as possible, you will naturally change how you write code. It doesn’t mean you have to follow all these rules, all the time. Find your balance with these rules, use some of them only if you feel comfortable with them.

These rules focus on maintainability, readability, testability, and comprehensibility of your code. If you already write code that is maintainable, readable, testable, and comprehensible, then these rules will help you write code that is more maintainable, more readable, more testable, and more comprehensible.

The 9 rules listed below:

1. Only One Level Of Indentation Per Method
1. Don’t Use The ELSE Keyword
1. Wrap All Primitives And Strings
1. First Class Collections
1. One Dot Per Line
1. Don’t Abbreviate
1. Keep All Entities Small
1. No Classes With More Than Two Instance Variables
1. No Getters/Setters/Properties

```javascript
(defun cost (estat1 estat2)
  ;;;;;;;;; Casos estat1 -> estat2
  (cond
    ((equal estat1 "A") (cond
      ((equal estat2 "B") 4)
      ((equal estat2 "C") 10)
      ((equal estat2 "D") 10)
      ((equal estat2 "E") 15)
      (t  0)
    ))
    ((equal estat1 "B") (cond
      ((equal estat2 "F") 5)
      (t  0)
    ))
    ((equal estat1 "C") (cond
      ((equal estat2 "F") 20)
      (t  0)
    ))
    ((equal estat1 "D") (cond
      ((equal estat2 "F") 10)
      (t  0)
    ))
    ((equal estat1 "E") (cond
      ((equal estat2 "F") 3)
      (t  0)
    ))
    ((equal estat1 "E") (cond
      ((equal estat2 "H") 30)
      (t  0)
    ))
    ((equal estat1 "F") (cond
      ((equal estat2 "G") 35)
      ((equal estat2 "H") 30)
      (t  0)
    ))
    ((equal estat1 "H") (cond
      ((equal estat2 "Z") 2)
      (t  0)
    ))
    (t  0)
  )
)
```