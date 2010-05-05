XmiRepository
=============

XmiRepository for ArgoUML and Poseidon XMI files.
Reads XMI files and makes the contained model available as java objects for
further processing. Retaines the structure of the XMI meta model. For
further processing the transformation into a model that's more convenient
to handle is adviced. 

Runtime Requirements:
---------------------

Castor-XML
Xerces
commons-logging

Version 1.0.0 (--.--.2010)
---------------------------

* support for collaborations (sequence diagrams)
* support for deployment models
* enhanced enumeration support
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
