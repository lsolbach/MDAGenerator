[
 :module "MDADomainMetaModel"
 :version "0.3.0"
 :type :framework
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :provider "soulspace.org"
 :description "Domain driven design extension for the meta model of the MDA Generator Framework repository.
    This module servers as an example how to extend the meta model."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/JavaPlugin"]
           ["org.soulspace.baumeister/JUnitPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.soulspace.modelling/MDARepository, 1.0.1" :dev]
                ["org.soulspace.modelling/MDAXmiRepository, 1.0.1" :dev]]
 ]
