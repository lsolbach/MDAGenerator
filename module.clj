[
 :module "ModelRepository"
 :project "org.soulspace.mda"
 :project-lead "Ludger Solbach"
 :vendor "soulspace.org"
 :type "framework"
 :version "1.0.0"
 :description "Model repository for model driven software development."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global" "sdeps" "java" "junit" "package"]
 :dependencies [[["org.soulspace.mda" "XmiRepository" "1.0.0"]]
                [["org.exolab" "castor" "0.9.5.3" "castor-xml"]]
                [["xerces" "xercesImpl" "2.9.1"]]
                [["junit" "junit" "3.8.1"] "dev"]]
 ]
