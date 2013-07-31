[
 :module "MDADomainMetaModel"
 :version "0.3.0"
 :type :framework
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :vendor "soulspace.org"
 
 :description
 "Domain driven design extension for the meta model of the MDA Generator Framework repository.
 This module servers as an example how to extend the meta model."
 
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global" "sdeps" "depsdot" "java" "package"]
 :dependencies [[["org.soulspace.mda" "MDARepository" "1.0.1"] :dev]
                [["org.soulspace.mda" "MDAXmiRepository" "1.0.1"] :dev]]
 ]
