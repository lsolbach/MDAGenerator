XmiRepository
=============

An XmiRepository for reading UML XMI 1.2 files (e.g. ArgoUML).
Reads XMI files and makes the contained model available as java objects for
further processing. Retains the structure of the XMI 1.2/UML 1.4 meta model.
For further processing the transformation into a model that's more convenient
to handle is advised (take a look the ModelRepository).

Runtime Requirements:
---------------------
External Dependencies
* Castor-XML 0.9.5.3
* XercesImpl >= 2.9.0

Author/Project Lead
------------
Ludger Solbach

License
-------
[Eclipse Public License 1.0] (http://www.eclipse.org/legal/epl-v10.html "EPL 1.0")

Copyright
---------
© 2004-2012 Ludger Solbach

Code Repository
---------------
[https://github.com/lsolbach/XmiRepository] (https://github.com/lsolbach/XmiRepository)

History
-------

Version 1.0.0 (--.--.2012)
---------------------------
* initial import to github
* switched to git
* support for collaborations (sequence diagrams)
* support for deployment models
* enhanced enumeration support
* enhanced support for state machine
* mark elements loaded from a profile

Version 0.9.13 (21.09.2009)
---------------------------
* support for loading multiple models into one xmi repository
* added href references
* added support for enumerations
* enhanced support for association classes
* enhanced support for comments
* enhanced support for state machines

Version 0.9.11 (31.08.2008)
---------------------------
* added package dependencies

Versions before (since 2004)
----------------------------
* everything else
