MdaGenerator
============

Version 0.9.19 (28.07.2011)
---------------------------

* added template search directories
* fixed directory names with namespacePrefix and namespaceSuffix
* added UML Profile support
* added generatorGroups
* added generators for actors and use cases
* added generators for states and transitions
* refactored generator core, make it ant independent to faciliate integration in other tools
    (TODO: remove reference to ClassPathUtils)
* refactored ModelGenerator to a subclass of ClassifierGenerator
* added generators for states and transitions

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