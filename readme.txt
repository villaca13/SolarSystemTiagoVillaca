
/* readme.txt

******************

Name : Tiago Linhares Villaca

Student Number: W20114785

Part A - Inheritance Hierarchy (24 / 24)
-----------------------------

Planets (10/10)
IcePlanet( 7 / 7)
GasPlanet ( 7 / 7)


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


Part D - DX (Overall style) (11%)	 (10 /11)
-----------------------------
Code correctly commented (3 / 3)
Standard naming, indentation, DRY Code etc. (5 / 5)
Javadoc written for PlanetSystemAPI  (2 / 3)

Part E - For Extra Credit (10%)  (10 / 10)
-----------------------------
Please list the following for each extra functionality that you implemented
     the extra functionality
     what changes this lead to from spec given
     where the extra implementation took place.

1- Extra Constructors for creating Planets with defaults values. No need to enter any detail.
Constructor created IcePlanet()/GasPlanet;
Changes on the add planets as well.

2- Core Composition Utility - Method public static List<String> getCoreKeys()
I have created this method there, to get a list of core keys and implement this as options on a menu which will be picked by the user.
When adding a planet, at the core composition item, a list pop up and it is asked to insert a number of the key selected.

3- METHOD public List<Planet> getPlanetsByType(String planetType) - Return a List<Planet> ( NOT A STRING)
Get a list of a specific type of planet. to be able to sort them by their unique variable.

4- Method deleteAllPlanets() - One more option added to the Delete menu.
I wanted this option to facilitate to clear up the list of planets. it also help to debug when I want to test some functionality
at the moment which The list of planets is empty.

5- "Add planet" and "Updated" use the same method planetDetails() in the driver file to avoid write a piece of code twice when asking the user the planet details.
Add Planet passes "A" to planet details.
Update passes "U" to planet details.

6- Method searchPlanetByName() - Extra search method to find a planet by its name.
Changes on the Driver and API controller files.

7 - Method sortGasPlanetsByRadiationLevel() - Extra sort method to sort ONLY Gas planets by its radiation level.
Changes on the Driver and API controller files.

8- Method sortPlanetsByGravity() - Extra sort method to sort All planets by its gravity which is not a field.
Changes on the Driver and API controller files.


Part F - Reflection (8 / 8)
-----------------------------
Filled out parts A - D above (3 / 3)

Rest(5 / 5)
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

3 - I found very hard to understand the abstract classes, Interfaces. I still have some doubt. It took some time to understand
the relationship between the classes an subclasses, accessing their variables/methods and so on. also dealing with lists were complicated when you need
unique fields.

4- The project structure were also challenging, trying to figure out where it is the best file to set up a method or variable.
it also took me some time to understand this part, what each file does. why we need them there.
I still need more practice to create a project from scratch, to design a good and standardized project.



Any bugs remaining in the solution or unfinished elements of spec (no need if you have detailed these in the rubric section)
Nothing that I know. Project seems to be working well.


Main learnings from my engagement with assignment

1- Improvement of debugging skills.
2- Improvement of handling data in list, sorting, searching.
3- a better understanding of abstract classes, statics methods and variables.
4- a better understanding of a project structure.
5- learning about persistence


Mandatory : PLease list any references used in your development/ implementation of your submission.
All the references and pieces of code were copied from the classes, I have searched on google a few things to understand some functionality.
No Major things or entire piece of code were copied from other sources.

Please consider the following statements and choose one (delete the inappropriate one)

- This is my work apart from the specific references noted above (and any code from class notes).
I understand the code and can describe any parts of the solution if needs be;


