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
(defun AtoB (estat info)
  (if (equal estat 'A) 'B 'buit))
(defun AtoC (estat info)
  (if (equal estat 'A) 'C 'buit))
(defun AtoD (estat info)
  (if (equal estat 'A) 'D 'buit))

(defun BtoD (estat info)
  (if (equal estat 'B) 'D 'buit))
(defun BtoG (estat info)
  (if (equal estat 'B) 'G 'buit))

(defun CtoE (estat info)
  (if (equal estat 'C) 'E 'buit))
(defun CtoB (estat info)
  (if (equal estat 'C) 'B 'buit))

(defun DtoE (estat info)
  (if (equal estat 'D) 'E 'buit))

(defun EtoF (estat info)
  (if (equal estat 'E) 'F 'buit))
(defun EtoH (estat info)
  (if (equal estat 'E) 'H 'buit))

(defun FtoG (estat info)
  (if (equal estat 'F) 'G 'buit))

(defun GtoH (estat info)
  (if (equal estat 'G) 'H 'buit))

(defun HtoI (estat info)
  (if (equal estat 'H) 'I 'buit))

(defun ItoC (estat info)
  (if (equal estat 'I) 'C 'buit))

(defvar tl-operadors
  (list (list 'AtoB #'AtoB)
        (list 'AtoC #'AtoC)
        (list 'AtoD #'AtoD)
        (list 'AtoE #'AtoE)
        (list 'BtoF #'BtoF)
        (list 'CtoF #'CtoF)
        (list 'DtoF #'DtoF)
        (list 'EtoF #'EtoF)
        (list 'EtoH #'EtoH)
        (list 'FtoG #'FtoG)
        (list 'FtoH #'FtoH)
        (list 'HtoI #'Htoi)))
```