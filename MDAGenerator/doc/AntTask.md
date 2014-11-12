MDA Generator Ant Task
======================

Definition of the `soulmda` Task
--------------------------------
The MdaGenerator framework provides an ant task to include a
generation step into the your build process.

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

The `soulmda` task does the setup of the generation step.
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
------------------------------
The `soulmda` task has generator subtasks that perform the actual
generation. The following generators are called for the corresponding
model elements. The list of model elements can be filtered by
specifying some filter criteria as parameters of the generator sub
tasks (e.g. 'stereotype').

#### `modelGenerator`
The `modelGenerator` gets called for every Model element in the ModelRepository

#### `packageGenerator`
The `packageGenerator` gets called for every Package element in the ModelRepository

#### `classGenerator`
The `classGenerator` gets called for every Class element in the ModelRepository

#### `interfaceGenerator`
The `interfaceGenerator` gets called for every Interface element in the ModelRepository

#### `stateMachineGenerator`
The `stateMachineGenerator` gets called for every StateMachine element in the ModelRepository

#### `stateGenerator`
`stateGenerator` gets called for every State element in the ModelRepository

#### `transitionGenerator`
The `transitionGenerator` gets called for every Transition element in the ModelRepository

#### `actorGenerator`
The `actorGenerator` gets called for every Actor element in the ModelRepository

#### `useCaseGenerator`
The `useCaseGenerator` gets called for every UseCase element in the ModelRepository

### Parameters of the Generator Subtasks ###
#### `name` ####
The name of the template to use. Mandatory.

#### `imports` ####
Comma seperated list of template includes. Optional.

#### `stereotype` ####
Input filter: The Stereotype to generate for. Special values are ALL
and NONE. Optional.

#### `basename` ####
Replaces the name of the element for the generation. Optional.

#### `extension` ####
Extension of the generated file. Optional.

#### `prefix` ####
Prefix appended in front of the name of the element. Optional.

#### `suffix` ####
Suffix appended after the name of the element. Optional.

#### `namespacePrefix` ####
Prefix appended in front of the namespace of the element. Optional.

#### `namespaceSuffix` ####
Suffix appended at the end of the namespace of the element. Optional.

#### `namespaceReplacement` ####
Replacement of the namespace of the element. Optional.

#### `useNameAsNamespace` ####
Appends the name of the element to the namespace of it. Optional.

#### `namespaceIncludes` ####
Input filter: Comma seperated list of namespaces/packages to be
included in the generation. Optional.

#### `namespaceExcludes` ####
Input filter: Comma seperated list of namespaces/packages to be
excluded from the generation. Optional.

#### `subdir` ####
Sub directory (below ) for the generated files. Optional.

#### `generationFilterPattern` ####
Output filter: regular expression. If the generated output matches
the regular expression, no file is written for this output. Can be
used to suppress the generation of empty files, for example.
Optional.

#### `encoding` ####
Encoding of the generated file. The specified encoding must be
available in the JVM. Optional.

#### `userSection` ####
Identifier for user sections in the generated code. Optional.

`param` SubTask of the Generator Tasks
--------------------------------------
The generators can be parameterized further with the `param` sub task.
The parameters are available as part of the DataSource provided to the
Template Engines generate call. They can be accessed with
GenCtx:<param-name> or GenCtx['<param-name>'] from within the
templates.

Use this mechanism to build generic templates and provide some
neccessary specifics of your project or organization as parameters.

### Parameters of the `param` Subtasks ###
#### `name` ####
Parameter name.

#### `value` ####
Value of the parameter.

Example
-------

```
<property name="generate.dir" value="${basedir}/generated"/>
<property name="backup.dir" value="${basedir}/backup"/>

<soulmda destdir="${generate.dir}"
         backupdir="${backup.dir}"
         templateDir="templates/"
         modelFile="model/MyModel.xmi">

    <classGenerator name="java/interface"
                    imports="lib,java/lib,java/interface,domain/java/lib,domain/java/entity-interface"
                    extension="java"
                    subdir="src"
                    stereotype="entity">
    </classGenerator>

    <classGenerator name="db/ddl"
                    imports="lib,db/lib,db/h2/dialect,db/create-table"
                    prefix="create_table_"
                    extension="sql"
                    subdir="db"
                    stereotype="entity">
        <param name="TablePrefix" value="T_"/>
    </classGenerator>

    <modelGenerator name="doc/html"
                    imports="lib,doc/html/lib,doc/html/css"
                    subdir="doc"
                    basename="MyModel"
                    extension="html"/>
</soulmda>
```