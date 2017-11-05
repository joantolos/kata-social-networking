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
(defun heuristica (estat)
  (cond
    ((equal estat "A") 15)
    ((equal estat "B") 2)
    ((equal estat "C") 15)
    ((equal estat "D") 18)
    ((equal estat "E") 7)
    ((equal estat "F") 5)
    ((equal estat "G") 0)
    ((equal estat "H") 9)
    ((equal estat "I") 2)
    (t  10)
  )
)
```