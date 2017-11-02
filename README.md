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

## Algorithm A*

```javascript
begin
  input the start node S and the set of GOALS of goal nodes;
  OPEN <- {S}
  G[S] <- 0;
  PRED[S] <- null;
  found <- false;

  while OPEN is not empty and found is false do
    begin
      L <- the set of nodes OPEN for which F is the least;

      if L is a singleton then let X be its sole element
      else if there are any goal nodes in L
        then let X be one of them;
        else let X be any element of L;

      remove X from OPEN and put X into CLOSED;

      if X is a goal node then found <- true
        else begin
          generate the set SUCCESSORS of successors of X;
          for each Y in SUCCESSORS do
            if Y is not already on OPEN or on CLOSED then
              begin
                G[Y] <- G[X] + distance(X,Y);
                F[Y] <- G[Y] + h(Y);
                PRED[Y] <- X;
                insert Y on OPEN;
              end
            else
              begin
                Z <- PRED[Y];
                temp <- F[Y]-G[Z] - distance(Z,Y) + G[X] + distance(X,Y);
                if temp < F[Y] then
                  begin
                    G[Y] <- G[Y] - F[Y] + temp;
                    F[Y] <- temp;
                    PRED[Y] <- X;
                    if Y is on CLOSED then
                      insert Y on OPEN and remove Y from CLOSED;
                  end;
              end;
        end;
    end;

  if found is false then output "Failure";
  else trace the pointers in the PRED fields from X back to S, "CONSing" each node onto the growing list of nodes to get the path from S to X;
end;
```