MDARepository
===============

The model repository  of the MDA Generator Framework to faciliate the generation of soure code from UML models.
UML 1.4 models from the xmi repository are transformed into model repository models, which are more convenient for the generation of (java) source code.

Runtime Requirements:
---------------------
External dependencies
* Castor-XML 0.9.5.3
* XercesImpl >= 2.9.0

Internal dependencies
* MDAXmiRepository >=1.0.1

Author/Project Lead
-------------------
Ludger Solbach

License
-------
Eclipse Public License 1.0 (http://www.eclipse.org/legal/epl-v10.html)

Copyright
---------
© 2004-2012 Ludger Solbach

Code Repository
---------------
[https://github.com/lsolbach/MDARepository] (https://github.com/lsolbach/MDARepository)

History
-------

Version 1.0.1 (28.07.2013)
--------------------------
* renamed to MDARepository
* refactored build files

Version 1.0.0 (18.12.2012)
--------------------------
* initial import to github
* switched to git
* added ParentElement reference to every element
* updated UML model
* added docs

Version 0.9.16 (08.09.2011)
---------------------------
* added SignalEvents
* added context to IStateMachine
* added dependencies and reverse dependencies on IInterface and IPackage
* added reverse dependencies on IClass
* added INode and IComponent
* added packages to model
* added checkOverride() to IAttribute, IAssociationEnd and IOperation
* use checkOverride() in getAll*() methods
* enumeration support via IEnumerationType
* mark elements loaded from a profile
* added toString() methods
* add return parameter to parameter list again so it's possible to
    access the parameter meta data of the return parameter
* added reference to parent element to some model elements

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

Versions before (since 2004)
----------------------------
* everything else
