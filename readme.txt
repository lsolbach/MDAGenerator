ModelRepository
===============

Version 0.9.16 (--.--.2010)
---------------------------
* added SignalEvents
* added context to IStateMachine
* added dependencies on IInterface
* added reverse dependencies on IClass
* added INode and IComponent
* added packages to model
* added checkOverride() to IAttribute, IAssociationEnd and IOperation
* use checkOverride() in getAll*() methods
* enumeration support via IEnumerationType
* mark elements loaded from a profile
* added toString() methods
* add return parameter to parameter list again so it's possible to
    access the parameter metadata of the return parameter
* added reference to parent element to model elements

Version 0.9.15 (21.09.2009)
---------------------------

* multi model support (e.g. UML Profiles)
* repository initialization with a given xmi repository
* further decoupling from a specific xmi repository
* enhanced support for association classes
* added SoulMDSDProfile for ArgoUML

Version 0.9.14 (09.09.2008)
---------------------------

* enhanced operations with some missing attributes (abstract, query, concurrency, ...)

Version 0.9.13 (01.09.2008)
---------------------------

* added package dependencies