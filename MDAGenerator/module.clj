[
 :module "MDAGenerator"
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :provider "soulspace.org"
 :type :framework
 :version "1.0.1"
 :description "Ant task and generators of the MDA generator framework for model driven software development."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/JavaPlugin"]
           ["org.soulspace.baumeister/JUnitPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.soulspace.template/TemplateEngine, 1.0.1"]
                ["org.soulspace.common/JavaUtilLibrary, 0.3.0"]
                ["org.soulspace.modelling/MDARepository, 1.0.1"]
                ["org.soulspace.modelling/MDAXmiRepository, 1.0.1"]
                ["org.apache.ant/ant, 1.8.3"]
                ["org.apache.ant/ant-testutil, 1.8.3" :dev]
                ["junit/junit, 3.8.1" :dev]]
 ]
