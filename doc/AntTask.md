MDA Generator Ant Task
======================

Definition of the `soulmda` Task
--------------------------------

To use the MdaGeneratorTask, it has to be registered within the ant
build file. If the property `soulmda.dir` points to the dirctory with
the jar files, the task can be registered with this declaration.

```
<path id="soulmda.classpath">
	<fileset dir="${soulmda.dir}">
		<include name="**/*.jar"/>
	</fileset>
</path>

<taskdef name="soulmda"
    classname="org.soulspace.mda.generator.ant.MdaGeneratorTask"
	classpathref="soulmda.classpath"/>
```

Usage of the `soulmda` Task
---------------------------

The `soulmda` task does the setup of the generation process.
It is used to specify which model to load, the directories to generate
to and where to look for the templates. 

### Parameters ###

#### `destdir` ####
Destination directory for the generated files.

#### `backupdir` ####
Directory of backup copies of the generated files.

#### `templateDir` ####
Directory where the template files reside.

#### `modelFile` ####
The xmi model file.

#### `modelFactory` ####
Fully qualified class name of a custom model factory to use.
Optional.

Subtasks of the `soulmda` Task
-------------------------------

The `soulmda` task has generator subtasks that perform the actual
generation. The following generators are called for the corresponding
model elements.

#### `modelGenerator`
#### `packageGenerator`
#### `classGenerator`
#### `interfaceGenerator`
#### `stateMachineGenerator`
#### `stateGenerator`
#### `transitionGenerator`
#### `actorGenerator`
#### `useCaseGenerator`

### Parameters of the Generator Subtasks ###

#### `name` ####
The name of the template to use.

#### `imports` ####
Comma seperated list of template includes.

#### `stereotype` ####
Stereotype to generate for. Special values are ALL and NONE.

#### `basename` ####
Replaces the name of the element for the generation.

#### `extension` ####
Extension of the generated file.

#### `prefix` ####
Prefix appended in front of the name of the element.

#### `suffix` ####
Suffix appended after the name of the element.

#### `namespacePrefix` ####
Prefix appended in front of the namespace of the element.

#### `namespaceSuffix` ####
Suffix appended at the end of the namespace of the element.

#### `namespaceReplacement` ####
Replacement of the namespace of the element.

#### `useNameAsNamespace` ####
Appends the name of the element to the namespace of it.

#### `namespaceIncludes` ####
Comma seperated list of namespaces/packages to be included in the generation.

#### `namespaceExcludes` ####
Comma seperated list of namespaces/packages to be excluded from the generation.

#### `subdir` ####
Sub directory (below ) for the generated files

#### `generationFilterPattern` ####
Regular expression. If the generated output matches the regular expression, no file is written for this output.

#### `encoding` ####
Encoding of the generated file. Must be available in the JVM.

#### `userSection` ####
Identifier for user sections in the generated code.

`param` SubTask of the Generator Tasks
------------------------------

### Parameters of the `param` Subtasks ###

#### `name` ####
#### `value` ####

Example:
```
<property name="generate.dir" value="${basedir}/generated"/>
<property name="backup.dir" value="${basedir}/backup"/>

<soulmda destdir="${generate.dir}"
         backupdir="${backup.dir}"
         templateDir="templates/"
         modelFile="model/MyModel.xmi"
         modelFactory="org.soulspace.mdlrepo.ddd.metamodel.impl.ModelFactory">

    <classGenerator name="java/domain/entity-interface" 
                    imports="base,java/base,java/domain/base"
                    extension="java"
                    subdir="src"
                    stereotype="entity">
    </classGenerator>

    <classGenerator name="db/createTable"
                    imports="base,db/base,db/db2/dialect"
                    prefix="create_table_"
                    extension="sql"
                    subdir="db2"
                    stereotype="entity">
        <param name="TablePrefix" value="T_"/>
    </classGenerator>

    <modelGenerator name="doc/html"
                    imports="base,doc/html/base,doc/html/css"
                    subdir="doc"
                    basename="MyModel"
                    extension="html"/>

</soulmda>
```
