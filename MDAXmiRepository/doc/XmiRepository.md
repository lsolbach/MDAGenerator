XmiRepository
=============

Using the XmiRepository
-----------------------

For an exmaple look at the class `org.soulspace.mda.generator.ClassifierGenerator`
in the **MdaGenerator** module.

Generating the XmiRepository Classes
------------------------------------
The UML meta model is specified in the XML Schema file `schema/uml.xsd`.
From this schema the java model is generated with the Castor-XML source
generator. The XMIRepository and the XMIBuilder classes are generated
by transforming the schema with XSL transformations, using the style
sheets `templates/repository.xsl` and `templates/builder.xsl`
respectively.

Input Model
-----------
schema/uml.xsd

Style Sheets
------------
templates/repository.xsl
templates/builder.xsl

Enhancing the UML Model
-----------------------
1. Add an element to the UML schema (uml.xsd).
2. Check repository.xsl and builder.xsl and add the element to the tests if it is an element with an XMI id.
 