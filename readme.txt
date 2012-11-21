XmiRepository
=============

An XmiRepository for ArgoUML and Poseidon XMI files.
Reads XMI files and makes the contained model available as java objects for
further processing. Retaines the structure of the XMI 1.2/UML 1.4 meta model.
For further processing the transformation into a model that's more convenient
to handle is adviced. 

Runtime Requirements:
---------------------
Castor-XML
Xerces
commons-logging

License
-------
Eclipse Public License 1.0 (http://www.eclipse.org/legal/epl-v10.html)

History
-------

Version 1.0.0 (--.--.201x)
---------------------------
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
