[
 :module "MdaGenerator"
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :vendor "soulspace.org"
 :type "framework"
 :version "1.0.0"
 :description "MDA generator framework for model driven software development. Contains generators and ant tasks."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global" "sdeps" "java" "package"]
 :dependencies [[["org.soulspace.template" "TemplateEngine" "1.0.0"]]
                [["org.soulspace.common" "JavaUtilLibrary" "0.3.0"]]
                [["org.soulspace.mda" "ModelRepository" "1.0.0"]]
                [["org.soulspace.mda" "XmiRepository" "1.0.0"]]
                [["org.apache.ant" "ant" "1.8.3"]]
                [["org.apache.ant" "ant-launcher" "1.8.3"] "dev"]
                [["org.apache.ant" "ant-testutil" "1.8.3"] "dev"]
                [["oro" "oro" "2.0.8"]]
                [["org.exolab" "castor" "0.9.5.3" "castor-xml"]]
                [["xerces" "xercesImpl" "2.9.1"]]
                [["junit" "junit" "3.8.1"] "dev"]]
 ]
