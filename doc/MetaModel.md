ModelRepository Meta Model
==========================
This is description of the meta model of the model repository.
The UML model of the ModelRepository MetaModel is located in the
`model` directory. You can use a recent version of the free ArgoUML to
view it.

Class Hierarchy
---------------
![Class Hierarchy](https://github.com/downloads/lsolbach/ModelRepository/ClassHierarchy.png "Meta Model Class Hierarchy Diagram")

In this diagram you can see the complete class hierarchy of the
currently implemented meta model. The root element is the type Element.
Every model element is derived from it.

Element
-------
![Element](https://github.com/downloads/lsolbach/ModelRepository/Element.png "Element Class Diagram")

Elements can have stereotypes and tagged values and a behavior.
A direct sub type of Element is the NamedElement which adds the
attribute name.

Classifier
----------
![Classifier](https://github.com/downloads/lsolbach/ModelRepository/Classifier.png "Classifier Class Diagram")


Package
-------
![Package](https://github.com/downloads/lsolbach/ModelRepository/Package.png "Package Class Diagram")


Class
-----
![Class](https://github.com/downloads/lsolbach/ModelRepository/Class.png "Class Class Diagram")

To make the meta model more convenient for generation there are some
differences in the model of Class with it's counterpart in the UML meta
model. A major difference is that classes have references to their
super classes and sub classes directly instead of having an explicit
Generalization type as in UML. The handling of Associations is another
major difference between the UML meta model and the meta model of the
ModelRepository. In the Model Repository the Association type is more
of an auxiliary type to make the stereotypes and tagged values of an
Association available. The main type transporting the information
needed for code generation is the Association end. Therefore the Class
type has direct references to the association ends.

State Machine
-------------
![State Machine](https://github.com/downloads/lsolbach/ModelRepository/StateMachine.png "State Machine Class Diagram")

State Machines in the meta model are modeled quite like in the UML meta
model. One difference is that State is the base type of all States
including the pseudo states. UML SimpleStates are directly mapped to
States in the model repository.

Actions
-------
![Actions](https://github.com/downloads/lsolbach/ModelRepository/Actions.png "Actions Class Diagram")


Events
------
![Events](https://github.com/downloads/lsolbach/ModelRepository/Events.png "Events Class Diagram")


UseCases
--------
![UseCases](https://github.com/downloads/lsolbach/ModelRepository/UseCases.png "Use Cases Class Diagram")


