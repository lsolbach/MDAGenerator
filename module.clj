[
 :name "MDAGenerator"
 :project "org.soulspace.modelling"
 :project-lead "Ludger Solbach"
 :vendor "soulspace.org"
 :type "framework"
 :version "1.0.0rc1"
 :description "MDA generator framework for model driven software development. Contains generators and ant tasks."
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :plugins ["global" "deps" "java" "package"]
 :dependencies [["org.soulspace" "TemplateEngine" "1.0.0rc7"]
                ["org.soulspace.modelling" "ModelRepository" "1.0.0"]
                ["org.soulspace.modelling" "XmiRepository" "1.0.0"]
                ["org.soulspace" "JavaUtilLibrary" "0.2.0"]
                ["oro" "oro" "2.0.8"]
                ["org.apache.ant" "ant" "1.8.3"]
                ["org.exolab" "castor" "0.9.5.3" "runtime" "castor-xml"]
                ["org.apache.ant" "ant-launcher" "1.8.3" "dev"]
                ["org.apache.ant" "ant-testutil" "1.8.3" "dev"]
                ["junit" "junit" "3.8.1" "dev"]]
 ]
