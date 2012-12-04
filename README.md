MdaGenerator
============

Generators and ant tasks for model driven software development based on
the TemplateEngine and the ModelRepository.

Runtime Requirements:
---------------------
Third party dependencies
* Jakarta ORO >= 2.0.8
* Castor-XML 0.9.5.3
* XercesImpl >= 2.9.0

Internal dependencies
* JavaUtilLibrary >= 0.3.0
* XmiRepository >= 1.0.0
* ModelRepository >= 1.0.0
* TemplateEngine >= 1.0.0

Documentation
-------------
See `doc/AntTask.md`.

Author/Project Lead
-------------------
Ludger Solbach

License
-------
[Eclipse Public License 1.0] (http://www.eclipse.org/legal/epl-v10.html "EPL 1.0")

Copyright
---------
© 2004-2012 Ludger Solbach

Code Repository
---------------
[https://github.com/lsolbach/MdaGenerator] (https://github.com/lsolbach/MdaGenerator)

History
-------

Version 1.0.0 (--.--.2012)
--------------------------
* initial import to github
* switched to git
* added encoding parameter to generators 

Version 0.9.19 (28.07.2011)
---------------------------
* added template search directories
* fixed directory names with namespacePrefix and namespaceSuffix
* added UML Profile support
* added generatorGroups
* added generators for actors and use cases
* added generators for states and transitions
* refactored generator core, make it ant independent to faciliate integration in other tools
* refactored ModelGenerator to a subclass of ClassifierGenerator

Version 0.9.14 (21.09.2009)
---------------------------
* updated dependencies
* new versions of TemplateEngine, XmiRepository, ModelRepository and DomainMetaModel
* added excludeStereotypes and includeStereotypes attributes
* added profiles attribute

Version 0.9.13 (10.09.2008)
---------------------------
* updated dependencies
* new versions of TemplateEngine, XmiRepository and ModelRepository

Version 0.9.12 (01.09.2008)
---------------------------
* updated dependencies
* added generation filter patterns
* made user sections optional and configurable
* made meta model configurable
* better error reporting
* added NONE and ALL as stereotype filters

Versions before (since 2004)
----------------------------
* everything else
