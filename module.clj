[
 :module "MDAXmiRepository"
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :vendor "soulspace.org"
 :type :framework
 :version "1.0.1"
 :description "UML XMI 1.2 repository of the MDA Generator Framework."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/MDDGeneratorPlugin"]
           ["org.soulspace.baumeister/JavaPlugin"]
           ["org.soulspace.baumeister/JUnitPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["junit/junit, 3.8.1" :dev]
                ["org.exolab/castor, 0.9.5.3, castor-xml"]
                ["xerces/xercesImpl, 2.9.1"]]
 ]
