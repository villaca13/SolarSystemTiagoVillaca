
/* readme.txt

******************

Name : Tiago Linhares Villaca

Student Number: W20114785

Part A - Inheritance Hierarchy (24 / 24)
-----------------------------

Planets (8/8)
IcePlanet( 8 / 8)
GasPlanet ( 8 / 8)


Part B - PlanetSystemAPI  (34 /34)
-----------------------------
basic CRUD (13 /13 )
reporting/numberOf methods (8 / 8)
validation methods  & persistence  (5 / 5)
sorting / top 5 (8 / 8)


Part C - UX (user experience) and Driver:Mark (23 /23)
-----------------------------
Good Menu Structure  (4 / 4)
ArrayListCRUD  - all  types handled  (7 / 7)
Reports Menu - for all planets (7 / 7)
Search, Sort, top5   (4 / 4)
Save, Load, Exit   (1 / 1)



Part D - DX (Overall style) (11%)	 (11 /11)
-----------------------------
Code correctly commented (3 / 3)
Standard naming, indentation, DRY Code etc. (5 / 5)
Javadoc written for PlanetSystemAPI  (3 / 3)

Part E - For Extra Credit (10%)  (x / 10)
-----------------------------
Please list the following for each extra functionality that you implemented
     the extra functionality
     what changes this lead to from spec given
     where the extra implementation took place.

1- Extra Constructors for creating Planets with defaults values. No need to enter any detail.
Constructor created IcePlanet()/GasPlanet;
Changes on the add planets as well.

2- METHOD public List<Planet> getPlanetsByType(String planetType) - Return a List<Planet> ( NOT A STRING)
Get a list of a specific type of planet. to be able to sort them by their unique variable.

3- Method deleteAllPlanets() - One more option added to the Delete menu.
I wanted this option to facilitate to clear up the list of planets. it also help to debug when I want to test some functionality
at the moment which The list of planets is empty.


Part F - Reflection (8 / 8)
-----------------------------
Filled out parts A - D above (3 / 3)

Rest(x / 5)
Chronology of my implementation (what I did first, etc.. )
I am using git to track the changes, the following sequence was created from it.

1- Project was set up with the starter code. I read the specs and plan of Action and then I have developed a plan of Action which would suit me best.
2- The Main Menu and the CRUD Menu were implemented first, I found it easier as the menu would work as sequence to follow.
3- Implementation of Planet, GasPlanet and IcePlanet was the second one. But Basic code, Variables, Some methods structure with no code inside.
4- Planet, GasPlanet and IcePlanet Constructors and Java Doc implemented.
5- CRUD Menu was created and its methods on PlanetSystemAPI, and Models Methods were coded (ToString, Classifybody, DisplayInfo).
6- Reports Menu was created and its methods on PlanetSystemAPI.
7- ISerializer ( Load, Save, FileName ) were implemented.
8- Search and Sort Menu was created and its methods on PlanetSystemAPI.
9- Fields Validation for Planet, GasPlanet and IcePlanet were implemented.
10- Extra functionality, final adjustments and readme.

Main difficulties I came across in your development of solution and how I solved them.

1- NextID - it was difficult to implement, initially it was always set as 1000 and then debugging I saw it was declared wrongly ( Not Static ).
Changed it to static and it started to increment.
Another issue was after loading a list of planets, set the ID with correct Next ID instead of starting over from 1000.
then I created a method " highestPlanetId() " to find the highest ID and then set nextID. This method is called always in the
Load() method so after loading , nextID is updated.

2 - Top 5 radiation level - It was challenging to sort only the Gas planet, It took some time to figure this out.
Create a method getPlanetsByType() to get a List of specific type of planet and them , sort them descending.
Finally, select the top five and remove the rest.



Any bugs remaining in the solution or unfinished elements of spec (no need if you have detailed these in the rubric section)
Nothing that I know. Project seems to be working well.


Main learnings from my engagement with assignment



Mandatory : PLease list any references used in your development/ implementation of your submission.
All the references were from the classes, I have searched on google a few things to understand some functionality.
No Major things or entire piece of code were copied from other sources.

Please consider the following statements and choose one (delete the inappropriate one)

- This is my work apart from the specific references noted above (and any code from class notes).
I understand the code and can decribe any parts of the solution if needs be;


